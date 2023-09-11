package br.com.cambuy.uai.core.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object Debounce {
    var debounceJob: Job? = null

    fun <T> debounce(
        waitMs: Long = DEBOUNCE_DEFAULT_TIME,
        coroutineScope: CoroutineScope,
        text: T,
        destinationFunction: suspend (T) -> Unit,
    ) {
        debounceJob?.cancel()
        debounceJob = coroutineScope.launch {
            delay(waitMs)
            destinationFunction(text)
        }
    }

    private const val DEBOUNCE_DEFAULT_TIME = 500L
}