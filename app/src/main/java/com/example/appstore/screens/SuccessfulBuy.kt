package com.example.appstore.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.ColorUtils
import androidx.navigation.NavController
import com.example.appstore.navigation.StoreScreens


@Composable
fun SuccessfulBuy(navController: NavController){
    val myColor = Color(0.1f, 0.7f, 0.1f, 0.7f)
    val mycolor = Color(0.9f, 0.8f, 0.9f, 1.0f)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = "exitoso",
            tint = myColor,
            modifier = Modifier
                .size(80.dp)

        )
        Text(
            text = "Compra Exitosa!",
            fontFamily = FontFamily.Cursive,
            fontSize = 46.sp,
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center
        )
        InfoText(text = "Numero de pedido: 0927287822")
        InfoText(text = "Gracias por tu compra!")
        Button(
            onClick = {
                navController.navigate(route = StoreScreens.MainScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            content = {
                Text(text = "Continuar", color = Color.Black)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = mycolor)
        )
    }


}
@Composable
fun InfoText(text: String){

    Text(
        text = text,
        fontFamily = FontFamily.SansSerif,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        color = Color.Black.copy(alpha = 0.4f)
    )

}