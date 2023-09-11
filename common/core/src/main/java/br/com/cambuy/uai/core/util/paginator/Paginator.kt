package br.com.cambuy.uai.core.util.paginator

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}