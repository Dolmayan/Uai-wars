package br.com.cambuy.uai.network.dto.comics

import br.com.cambuy.uai.network.dto.ThumbnailDto
import com.google.gson.annotations.SerializedName

data class ComicDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("thumbnail")
    val thumbnailDto: ThumbnailDto? = null,
)