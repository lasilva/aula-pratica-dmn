package br.com.foodDelivery.tiaLuDelivery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.foodDelivery.tiaLuDelivery.ui.basicComposables.AmountOption
import br.com.foodDelivery.tiaLuDelivery.ui.basicComposables.FormField
import br.com.foodDelivery.tiaLuDelivery.ui.basicComposables.MainButton
import br.com.foodDelivery.tiaLuDelivery.ui.basicComposables.Title
import br.com.foodDelivery.tiaLuDelivery.ui.basicComposables.UploadButton
import br.com.foodDelivery.tiaLuDelivery.viewModel.ProdutoViewModel
import java.math.BigDecimal

// UI - Apenas minha View
@Composable
fun ProductRegisterForm(modifier: Modifier = Modifier,
                        viewModel: ProdutoViewModel = viewModel(),
                        navController: NavController){

    val produtoUiState by viewModel.produtoUiState.collectAsState()

    Column(
        modifier = modifier.padding(start = 30.dp,
            end = 20.dp)
    ) {
        Title(
            title = "Cadastro de Produto",
            modifier = modifier
                .padding(top = 20.dp,
                end = 20.dp)
        )
        FormField(label = "Nome",
            width = 332.dp,
            height = 50.dp,
            modifier = modifier.padding(top = 20.dp),
            leftPadding = 0.dp,
            value = produtoUiState.nome,
            isError = produtoUiState.isErrorName) {
            novoNome -> viewModel.atualizarNome(novoNome)
        }
        Row(modifier = modifier.padding(top = 20.dp)) {
            Column (modifier = modifier){
                FormField(
                    label = "Preço",
                    width = 150.dp,
                    height = 50.dp,
                    leftPadding = 0.dp,
                    modifier = modifier.padding(bottom = 20.dp),
                    value = produtoUiState.precoUnitario,
                    isError = produtoUiState.isErrorPreco,
                    keyboard = KeyboardType.Decimal,
                    onValueChanged = { novoPreco -> viewModel.atualizarPreco(novoPreco) }
                )
                AmountOption(amount = produtoUiState.quantidade, updateAmount = {
                        novaQuantidade -> viewModel.atualizarQuantiade(novaQuantidade)
                })
            }
            UploadButton()
        }

        FormField(
            label = "Descrição",
            width = 332.dp,
            height = 150.dp,
            leftPadding = 0.dp,
            modifier = modifier.padding(top = 20.dp),
            value = produtoUiState.descricao,
            onValueChanged = { novaDescricao -> viewModel.atualizarDescricao(novaDescricao) }
        )
        FormField(
            label = "Código PDV",
            width = 332.dp,
            height = 50.dp,
            modifier = modifier.padding(top = 20.dp,
                bottom = 20.dp),
            leftPadding = 0.dp,
            value = produtoUiState.codigoPDV,
            onValueChanged = { novoCodigo -> viewModel.atualizarCodigoPDV(novoCodigo) }
        )

        MainButton(
            text = "Salvar",
            width = 332.dp,
            height = 60.dp,
            modifier = modifier.padding(bottom = 20.dp,
                top = 150.dp)) {

            navController.popBackStack()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductRegisterFormPreview(){
    ProductRegisterForm(navController = rememberNavController())
}