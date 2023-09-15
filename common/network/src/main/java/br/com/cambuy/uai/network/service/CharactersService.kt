package br.com.cambuy.uai.network.service

import br.com.cambuy.uai.network.dto.CharacterDto
import br.com.cambuy.uai.network.dto.PeopleResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersService {

    @GET("people/?page/")
    suspend fun getCharacters(@Query("page") page: Int): Response<PeopleResponseDto>

    @GET("people/{id}/")
    suspend fun getCharactersById(@Path("id") id: Int): Response<CharacterDto>
}