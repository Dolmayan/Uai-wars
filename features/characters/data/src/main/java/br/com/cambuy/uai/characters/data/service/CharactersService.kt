package br.com.cambuy.uai.characters.data.service

import br.com.cambuy.uai.characters.data.dto.PeopleResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersService {

    @GET("people/?page/")
    suspend fun getCharacters(@Query("page") page: Int): Response<PeopleResponseDto>
}