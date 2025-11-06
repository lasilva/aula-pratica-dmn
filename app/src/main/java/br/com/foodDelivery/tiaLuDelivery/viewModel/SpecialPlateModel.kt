package br.com.foodDelivery.tiaLuDelivery.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.math.BigDecimal

class SpecialPlateModel: ViewModel() {

    private val _plate = MutableStateFlow<Plate>(Plate())
    val plate: StateFlow<Plate> = _plate.asStateFlow()
    data class Plate(val imageUrl: String = "",
                     val name: String = "",
                     val price: BigDecimal = BigDecimal.ZERO,
                     val id: Int = -1)


}