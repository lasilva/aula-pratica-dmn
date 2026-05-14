package br.com.foodDelivery.tiaLuDelivery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.foodDelivery.tiaLuDelivery.ui.basicComposables.AmountOption
import br.com.foodDelivery.tiaLuDelivery.ui.basicComposables.FormField
import br.com.foodDelivery.tiaLuDelivery.ui.basicComposables.MainButton
import br.com.foodDelivery.tiaLuDelivery.ui.basicComposables.Title
import br.com.foodDelivery.tiaLuDelivery.ui.basicComposables.UploadButton
import java.math.BigDecimal


@Composable
fun ProductRegisterForm(modifier: Modifier = Modifier,
                        navController: NavController){

    var nome = ""
    var preco by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var codigoPDV by remember { mutableStateOf("") }
    var quantidade by remember { mutableStateOf(0) }

    var isErrorNome by remember { mutableStateOf(false) }
    var isErrorPreco by remember { mutableStateOf(false) }

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
            value = nome,
            isError = isErrorNome) {
            novoNome -> nome = novoNome
            isErrorNome = nome.length < 3
        }
        Row(modifier = modifier.padding(top = 20.dp)) {
            Column (modifier = modifier){
                FormField(
                    label = "Preço",
                    width = 150.dp,
                    height = 50.dp,
                    leftPadding = 0.dp,
                    modifier = modifier.padding(bottom = 20.dp),
                    value = preco,
                    isError = isErrorPreco,
                    keyboard = KeyboardType.Decimal,
                    onValueChanged = { novoPreco ->
                        preco = novoPreco
                        val precoUnitario: BigDecimal = if (preco.isNotBlank()) BigDecimal(preco).setScale(2) else BigDecimal.ZERO
                        isErrorPreco = precoUnitario.compareTo(BigDecimal.ZERO) <= 0
                    }
                )

                AmountOption(amount = quantidade, updateAmount = {
                        novaQuantidade -> quantidade = novaQuantidade
                })

                AmountOption(amount = quantidade) {
                    novaQuantidade -> quantidade = novaQuantidade
                }
            }
            UploadButton()
        }

        FormField(
            label = "Descrição",
            width = 332.dp,
            height = 150.dp,
            leftPadding = 0.dp,
            modifier = modifier.padding(top = 20.dp),
            value = descricao,
            onValueChanged = { novaDescricao -> descricao = novaDescricao }
        )
        FormField(
            label = "Código PDV",
            width = 332.dp,
            height = 50.dp,
            modifier = modifier.padding(top = 20.dp,
                bottom = 20.dp),
            leftPadding = 0.dp,
            value = codigoPDV,
            onValueChanged = { novoCodigo -> codigoPDV = novoCodigo }
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
}

@Preview(showBackground = true)
@Composable
fun FormFieldPreview(){
    FormField(
        label = "Nome",
        width = 332.dp,
        height = 50.dp,
        leftPadding = 30.dp,
        value = "",
        onValueChanged = {novoValor -> println(novoValor)}
    )
}


@Preview(showBackground=true)
@Composable
fun TitlePreview(){
    Title(title = "Cadastro de Produto")
}




@Composable
fun FormFieldCorreto() {

}