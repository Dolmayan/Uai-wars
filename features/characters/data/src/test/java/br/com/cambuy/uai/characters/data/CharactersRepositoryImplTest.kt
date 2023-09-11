package br.com.cambuy.uai.characters.data

import br.com.cambuy.characters.domain.CharactersRepository
import br.com.cambuy.uai.characters.data.responses.genericError
import br.com.cambuy.uai.characters.data.responses.validGetCharactersResponse
import br.com.cambuy.uai.characters.data.service.CharactersService
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CharactersRepositoryImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var repository: CharactersRepository
    private lateinit var service: CharactersService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        mockWebServer = MockWebServer()
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()

        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/").toString())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharactersService::class.java)

        repository = CharactersRepositoryImpl(
            service = service
        )
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `given getCharacters request, then we wait for a correct response with code 200`() =
        runBlocking {
            mockWebServer.enqueue(
                MockResponse()
                    .setResponseCode(RESPONSE_SUCCESS)
                    .setBody(validGetCharactersResponse)
            )

            val result = repository.getCharactersList(1)

            Truth.assertThat(result.data).isNotNull()
            Truth.assertThat(result.error).isNull()
        }

    @Test
    fun `given getCharacters request, then we wait for a response with code 204 without content`() =
        runBlocking {
            mockWebServer.enqueue(
                MockResponse()
                    .setResponseCode(RESPONSE_SUCCESS_WITH_NO_BODY)
            )

            val result = repository.getCharactersList(1)

            Truth.assertThat(result.data).isNull()
            Truth.assertThat(result.error).isNotNull()
        }

    @Test
    fun `given getCharacters request, then we wait for a response with code 400 with content`() =
        runBlocking {
            mockWebServer.enqueue(
                MockResponse()
                    .setResponseCode(RESPONSE_ERROR_WITH_BODY)
                    .setBody(genericError)
            )

            val result = repository.getCharactersList(1)

            Truth.assertThat(result.data).isNull()
            Truth.assertThat(result.error).isNotNull()
        }

    @Test
    fun `given getCharacters request, then we wait for an error response with code 404`() =
        runBlocking {
            mockWebServer.enqueue(
                MockResponse()
                    .setResponseCode(RESPONSE_ERROR)
            )

            val result = repository.getCharactersList(1)

            Truth.assertThat(result.data).isNull()
            Truth.assertThat(result.error).isNotNull()
        }

    @Test
    fun `given getCharacters request, when no have connectivity, then expected an error response`() =
        runBlocking {
            mockWebServer.shutdown()

            val result = repository.getCharactersList(1)

            Truth.assertThat(result.data).isNull()
            Truth.assertThat(result.error).isNotNull()
        }

    private companion object {
        const val RESPONSE_SUCCESS = 200
        const val RESPONSE_SUCCESS_WITH_NO_BODY = 204
        const val RESPONSE_ERROR_WITH_BODY = 400
        const val RESPONSE_ERROR = 404
    }
}