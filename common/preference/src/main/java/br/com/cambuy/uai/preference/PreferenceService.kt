package br.com.cambuy.uai.preference

interface PreferenceService {
    suspend fun updateFavorite(id: Int)
    suspend fun getUserData(): UserPreferenceModel
}