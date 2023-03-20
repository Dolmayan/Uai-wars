package br.com.cambuy.uai.preference

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {

    @Provides
    fun providePreferenceService(@ApplicationContext context: Context): PreferenceService {
        return PreferenceServiceImpl(context = context)
    }
}