package br.com.cambuy.uai.preference

import android.content.Context
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class PreferenceServiceImpl @Inject constructor(
    private val context: Context,
) : PreferenceService {

    private val userPreferencesFlow: Flow<UserPreferenceModel>
        get() = context.dataStore.data

    override suspend fun updateFavorite(id: Int) {
        context.dataStore.updateData {
            it.copy(favoriteCharacter = FavoriteCharacter(id = id, name = ""))
        }
    }

    override suspend fun getUserData(): UserPreferenceModel {
        return userPreferencesFlow.first()
    }
}