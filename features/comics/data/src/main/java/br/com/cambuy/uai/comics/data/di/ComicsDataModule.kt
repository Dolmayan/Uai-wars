package br.com.cambuy.uai.comics.data.di

import br.com.cambuy.uai.comics.data.ComicsRepositoryImpl
import br.com.cambuy.uai.comics.domain.ComicsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ComicsDataModule {

    @Binds
    @Singleton
    abstract fun bindsComicsRepository(
        comicsRepositoryImpl: ComicsRepositoryImpl,
    ): ComicsRepository
}