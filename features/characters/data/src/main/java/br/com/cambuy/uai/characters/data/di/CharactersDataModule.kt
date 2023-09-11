package br.com.cambuy.uai.characters.data.di

import br.com.cambuy.characters.domain.CharactersRepository
import br.com.cambuy.uai.characters.data.CharactersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class CharactersDataModule {

    @Binds
    @Singleton
    abstract fun bindsCharactersRepository(
        charactersRepositoryImpl: CharactersRepositoryImpl,
    ): CharactersRepository
}