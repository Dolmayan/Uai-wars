package br.com.cambuy.uai.design_system

sealed interface StateOfUi {
    object View : StateOfUi
    object Loading : StateOfUi
    data class Error(val action: () -> Unit) : StateOfUi
}