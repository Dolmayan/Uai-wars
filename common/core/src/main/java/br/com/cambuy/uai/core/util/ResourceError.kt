package br.com.cambuy.uai.core.util

sealed class ResourceError<T>(
    val errorCode: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val data: T? = null,
) {

    class CharactersError<T>(
        errorCode: Int? = null,
        title: String? = null,
        description: String? = null
    ) : ResourceError<T>(errorCode = errorCode, title = title, description = description)
}