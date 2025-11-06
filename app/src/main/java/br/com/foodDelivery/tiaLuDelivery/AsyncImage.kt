package br.com.foodDelivery.tiaLuDelivery

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CarregarImagemComDetalhes(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "Imagem carregada da internet",
        placeholder = painterResource(id = R.drawable.plate1), // Opcional
        error = painterResource(id = R.drawable.arrow_details),           // Opcional
        modifier = Modifier.size(250.dp),
        contentScale = ContentScale.Crop // Opcional
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewImageAsync() {
    CarregarImagemComDetalhes("https://receitadaboa.com.br/wp-content/uploads/2024/10/Macarronada.jpg")
}