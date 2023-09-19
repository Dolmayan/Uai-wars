package br.com.cambuy.uai.network.service

import br.com.cambuy.uai.network.dto.CharacterResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersService {

    @GET("characters")
    suspend fun getCharacters(
        @Query("limit") page: Int,
        @Query("nameStartsWith") nameStartsWith: String? = null,
    ): Response<CharacterResponseDto>

    @GET("characters/{characterId}")
    suspend fun getCharactersById(@Path("characterId") id: Int): Response<CharacterResponseDto>
}