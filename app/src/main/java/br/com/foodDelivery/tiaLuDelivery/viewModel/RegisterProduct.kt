package br.com.foodDelivery.tiaLuDelivery.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.math.BigDecimal

class RegisterProduct : ViewModel() {

    private val _product = MutableStateFlow<Product>(Product())
    val product: StateFlow<Product> = _product.asStateFlow()

    data class Product(val name: String = "Default name",
                       val imageUrl: String = "",
                       val price: BigDecimal = BigDecimal.ZERO,
                       val amount: Int = 1,
                       val description: String = "",
                       val salePointCode: Int = 0)



}