package br.com.cambuy.uai.comics.data.pagging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.cambuy.uai.comics.domain.model.Comic
import br.com.cambuy.uai.network.service.ComicsService

class ComicsPagingSource(
    private val service: ComicsService,
    private val textSearch: String
): PagingSource<Int, Comic>() {

    override fun getRefreshKey(state: PagingState<Int, Comic>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Comic> {
        TODO("Not yet implemented")
    }
}