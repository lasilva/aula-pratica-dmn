package br.com.foodDelivery.tiaLuDelivery.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal

// ViewModel - Como se fosse nosso controller
class ProdutoViewModel : ViewModel() {

    private val _produtoUiState = MutableStateFlow(ProdutoUiState()) // pode ser alterado
    val produtoUiState: StateFlow<ProdutoUiState> = _produtoUiState.asStateFlow() // apenas leitura

    fun atualizarNome(novoNome: String) {
        _produtoUiState.update {  currentState ->
            currentState.copy(nome = novoNome,
                isErrorName =  novoNome.isBlank() || novoNome.length < 3)
        }
    }

    fun atualizarQuantiade(novoQuantidade: Int) {
        _produtoUiState.update {  currentState ->
            currentState.copy(quantidade = novoQuantidade)
        }
    }

    fun atualizarPreco(preco: String) {
        _produtoUiState.update { currentState ->
            val isValid = BigDecimal(preco).compareTo(BigDecimal.ZERO) < 0
            currentState.copy(
                precoUnitario = preco,
                isErrorPreco = isValid
            )
        }
    }

    fun atualizarDescricao(descricao: String) {
        _produtoUiState.update { currentState ->
            currentState.copy(descricao = descricao)
        }
    }

    fun atualizarCodigoPDV(codigoPDV: String) {
        _produtoUiState.update { currentState ->
            currentState.copy(
                codigoPDV = codigoPDV
            )
        }
    }
}