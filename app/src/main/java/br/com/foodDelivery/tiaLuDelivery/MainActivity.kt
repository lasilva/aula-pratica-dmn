package br.com.foodDelivery.tiaLuDelivery

import br.com.foodDelivery.tiaLuDelivery.R

import androidx.compose.ui.graphics.Color

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.foodDelivery.tiaLuDelivery.ui.theme.TiaLuDeliveryTheme
import coil.compose.AsyncImage
import java.math.BigDecimal
import java.math.RoundingMode
import br.com.foodDelivery.tiaLuDelivery.ui.theme.poppins

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TiaLuDeliveryTheme {
                ProductRegisterForm()
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun SaudacaoUsuario(name: String) {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = "Olá, $name",
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            fontSize = 32.sp,
            fontFamily = poppins
        )
        Text(
            text =  "O que você quer pedir hoje?",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            fontFamily = poppins
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SaudacaoUsuarioPreview() {
    TiaLuDeliveryTheme {
        ProductRegisterForm()
    }
}


@Composable
fun MyPlate(
    drawableId: Int,
    imageUrl: String = "",
    size: Int = 128
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "Imagem carregada da internet",
        placeholder = painterResource(id = R.drawable.plate1), // Opcional
        error = painterResource(id = drawableId),           // Opcional
        modifier = Modifier.size(size.dp)
            .padding(start = 10.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop // Opcional
    )
}

@Composable
fun TipoPrato(drawableId: Int,
              nomePrato: String = "None") {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(drawableId),
            contentDescription = "Prato $nomePrato",
            modifier = Modifier.size(width = 27.dp, height = 21.dp)
        )
        Text(
            text = nomePrato,
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            fontFamily = poppins
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TipoPratoPreview() {
        TipoPrato(
            drawableId = R.drawable.all_plates,
            nomePrato = "All")
}

@Composable
fun PlateItem(itemName: String = "None",
              itemPrice: BigDecimal = BigDecimal.ZERO,
              itemId: Int = -1) {
    Box(
        modifier = Modifier
            .size(width = 200.dp, height = 300.dp)
            .padding(start = 32.dp)
            .background(Color(0xFFFDD0B5),
                shape = RoundedCornerShape(32.dp))
    ) {
        Text(text = itemName,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontFamily = poppins,
            modifier = Modifier.padding(start = 10.dp, top = 152.dp))

        Text(text = "R$ ${itemPrice.setScale(2, RoundingMode.HALF_UP).toPlainString()}",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            fontFamily = poppins,
            modifier = Modifier.padding(start = 10.dp, top = 178.dp))

        Row(modifier = Modifier.padding(start = 10.dp,
            bottom = 20.dp,
            top = 250.dp,
            end = 10.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Veja mais",
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                fontFamily = poppins)

            Button(onClick = {
                println("clicou")
            },
                modifier = Modifier.size(24.dp),
                contentPadding = PaddingValues(0.dp) ) {
                Image(
                    painter = painterResource(R.drawable.arrow_details),
                    contentDescription = "Circular Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

    }
    MyPlate(imageUrl = "https://phygital-files.mercafacil.com/catalogo/uploads/produto/refrigerante_coca_cola_sabor_original_1_5l_c90d5163-88d5-4a6e-b14c-a954c55c5260.webp",
        drawableId = R.drawable.plate1, size = 152)
}

@Preview(showBackground = true)
@Composable
fun SpecialPlate() {
    PlateItem(itemName = "Noodles", itemPrice = BigDecimal(7.20))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TiaLuDeliveryTheme {
        Greeting("Android")
    }
}

@Composable
fun RetanguloComCantosExtremos() {
    // Cor para combinar com a imagem que você enviou
    val corRetangulo = Color(0xFFFDD0B5) // Um tom de pêssego/laranja claro

    Box(
        modifier = Modifier
            // Define a largura para preencher a tela, e uma altura fixa
            .fillMaxWidth(0.8f) // 80% da largura da tela, por exemplo
            .height(200.dp)     // Altura de 200 dp
            // Aplica o fundo com a cor e a forma dos cantos
            .background(
                color = corRetangulo,
                // A chave é um valor alto para o raio de arredondamento
                shape = RoundedCornerShape(32.dp) // Experimente com valores como 24.dp, 32.dp, 40.dp
            )
            // Adiciona um padding externo para afastar das bordas da tela, se necessário
            .padding(horizontal = 16.dp)
    ) {
        // Você pode colocar conteúdo aqui dentro, como Text, Image, Column, Row
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewRetanguloExtremo() {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        RetanguloComCantosExtremos()
    }
}

@Composable
fun ItemMenu(plateDrawableId: Int,
             title: String,
             description: String,
             price: BigDecimal,
             amount: Int) {

    Row {
        Image(
            painter = painterResource(plateDrawableId),
            contentDescription = "Prato $title",
            modifier = Modifier.size(100.dp)
                .padding(start = 30.dp)
        )
        Column(modifier = Modifier.padding(start = 20.dp,
            top = 10.dp)) {
            Text(text = title,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                fontFamily = poppins)
            Text(text = description,
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                fontFamily = poppins)
        }
        Column (modifier = Modifier.padding(start = 30.dp,
            top = 10.dp)) {
            Text(text = "R$ ${price.setScale(2)}",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                fontFamily = poppins)
            Row (modifier = Modifier.padding(top = 20.dp))
            {
                Button(onClick = {
                    println("clicou no +")
                },
                modifier = Modifier.size(24.dp),
                contentPadding = PaddingValues(0.dp) ) {
                    Image(
                        painter = painterResource(R.drawable.somar),
                        contentDescription = "Adicionar o valor",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Text(text = "$amount",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    fontFamily = poppins,
                    modifier = Modifier.padding(start= 10.dp, end=10.dp))

                Button(onClick = {
                    println("clicou no -")
                },
                    modifier = Modifier.size(24.dp),
                    contentPadding = PaddingValues(0.dp) ) {
                    Image(
                        painter = painterResource(R.drawable.reduzir),
                        contentDescription = "Reduzir o valor",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemMenuExtremo() {
    ItemMenu(R.drawable.plate1,
        "Macarrão",
        "com camarão, ovos e porco",
        BigDecimal.valueOf(7.50),
        1)
}