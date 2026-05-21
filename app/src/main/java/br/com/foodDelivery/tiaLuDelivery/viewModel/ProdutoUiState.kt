package br.com.foodDelivery.tiaLuDelivery.viewModel

import java.math.BigDecimal

// Classe do meu model
data class ProdutoUiState(
    var nome: String = "",
    var precoUnitario: String = "",
    var quantidade: Int = 0,
    var descricao: String = "",
    var codigoPDV: String = "",
    var isErrorName: Boolean = false,
    var isErrorPreco: Boolean = false
)