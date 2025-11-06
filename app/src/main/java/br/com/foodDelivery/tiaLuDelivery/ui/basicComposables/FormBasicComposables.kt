package br.com.foodDelivery.tiaLuDelivery.ui.basicComposables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.foodDelivery.tiaLuDelivery.R
import br.com.foodDelivery.tiaLuDelivery.ui.theme.poppins
import br.com.foodDelivery.tiaLuDelivery.ui.theme.ButtonOrange

@Composable
fun Title(modifier: Modifier = Modifier, title: String = "No title"){
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontFamily = poppins,
        color = Color.Black,
        fontSize = 24.sp,
        modifier = modifier
    )
}

@Composable
fun FormField(modifier: Modifier = Modifier,
              label: String = "No label",
              width: Dp = 30.dp,
              height: Dp = 30.dp,
              leftPadding: Dp = 30.dp,
              value: String = "",
              onValueChanged: (String) -> Unit) {
    OutlinedTextField(
        label = {
            Text(text = label,
                fontFamily = poppins)
        },
        onValueChange = onValueChanged,
        value = value,
        modifier = modifier
            .size(width=width, height=height)
            .padding(start = leftPadding),
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color(0xFFFDD0B5),
            focusedTextColor = Color.Black
        )
    )
}

@Composable
fun AmountOption(modifier: Modifier = Modifier,
                 amount: Int = 0,
                 updateAmount: (Int) -> Unit) {
    Row {
        Button(onClick = {
            updateAmount(amount + 1)
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
            if(amount == 0) {
              updateAmount(0)
            } else {
                updateAmount(amount - 1)
            }
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

@Composable
fun UploadButton(){

}

@Composable
fun MainButton(modifier: Modifier = Modifier,
               text: String,
               width: Dp,
               height: Dp,
               clickAction: () -> Unit) {
    Button(
        onClick = { clickAction() },
        modifier = modifier.background(
            ButtonOrange,
            shape = RoundedCornerShape(24.dp))
            .size(width=width, height=height),
        colors = ButtonDefaults.buttonColors(
            containerColor = ButtonOrange,
            contentColor = Color.White
        )
    ) {
        Text(
            text = text,
            fontFamily = poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainButtonPreview(){
    MainButton(text = "Salvar",
        width = 332.dp,
        height = 60.dp) {
        println("Salvar")
    }
}
