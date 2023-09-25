package br.com.cambuy.uai.network

import br.com.cambuy.uai.network.interceptor.HttpsInterceptor
import br.com.cambuy.uai.network.service.CharactersService
import br.com.cambuy.uai.network.service.ComicsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideInterceptor(): HttpsInterceptor {
        return HttpsInterceptor()
    }

    @Provides
    @Singleton
    fun provideCharacterService(interceptor: HttpsInterceptor): CharactersService {
        return createService(BASE_URL, interceptor)
    }

    @Provides
    @Singleton
    fun provideComicsService(interceptor: HttpsInterceptor): ComicsService {
        return createService(BASE_URL, interceptor)
    }

    private inline fun <reified T> createService(
        baseUrl: String,
        interceptor: HttpsInterceptor,
        connectTimeout: Long = DEFAULT_TIMEOUT,
        readTimeout: Long = DEFAULT_TIMEOUT,
    ): T =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                createOkHttpClient(
                    connectTimeout = connectTimeout,
                    readTimeout = readTimeout,
                    interceptor = interceptor
                )
            )
            .build()
            .create(T::class.java)

    private fun createOkHttpClient(
        connectTimeout: Long,
        readTimeout: Long,
        interceptor: HttpsInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(makeLoggingInterceptor())
            .addInterceptor(interceptor)
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)
            .build()
    }

    private fun makeLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private const val BASE_URL = "https://gateway.marvel.com/v1/public/"
    private const val DEFAULT_TIMEOUT = 20L
}