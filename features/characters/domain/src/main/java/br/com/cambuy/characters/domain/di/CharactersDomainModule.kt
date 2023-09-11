package br.com.cambuy.characters.domain.di

import br.com.cambuy.characters.domain.useCase.GetCharactersUseCase
import br.com.cambuy.characters.domain.useCase.GetCharactersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class CharactersDomainModule {

    @Binds
    abstract fun provideGetCharactersUseCase(
        getCharactersUseCaseImpl: GetCharactersUseCaseImpl,
    ): GetCharactersUseCase
}