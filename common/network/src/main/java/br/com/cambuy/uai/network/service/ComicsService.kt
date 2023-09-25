package br.com.cambuy.uai.network.service

import br.com.cambuy.uai.network.dto.character.CharacterResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicsService {

    @GET("comics")
    suspend fun getComics(
        @Query("limit") page: Int,
        @Query("titleStartsWith") titleStartsWith: String? = null,
    ): Response<CharacterResponseDto>

    @GET("comics/{comicId}")
    suspend fun getComicsById(@Path("comicId") id: Int): Response<CharacterResponseDto>
}