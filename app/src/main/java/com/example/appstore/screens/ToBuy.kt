package com.example.appstore.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appstore.navigation.StoreScreens

var email : MutableState<String> = mutableStateOf("")
var phoneNumber: MutableState<String> = mutableStateOf("")
var address : MutableState<String> = mutableStateOf("")
var cardNumber : MutableState<String> = mutableStateOf("")
@Composable
fun ToBuy(navController: NavController){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        DescriptionProductBuy(navController)
        PurchaceForm(navController)
    }
}
@Composable
fun DescriptionProductBuy(navController : NavController){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "atras",
                tint = Color.Black,
                modifier = Modifier
                    .size(50.dp)
                    .padding(10.dp)
                    .clickable(true, onClick = { navController.popBackStack() })
            )
            Spacer(modifier = Modifier.widthIn(10.dp))
            Text(
                text = "Formulario De Pago",
                fontFamily = FontFamily.Cursive,
                fontSize = 36.sp,
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Center
            )
    }
}
@Composable
fun PurchaceForm(navController: NavController){
    var email by remember {mutableStateOf("")}
    var phoneNumber by remember {mutableStateOf("")}
    var address by remember {mutableStateOf("")}
    var cardNumber by remember {mutableStateOf("")}
    val mycolor = Color(0.9f, 0.8f, 0.9f, 1.0f)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it},
            label = { Text("Correo Electronico")},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                focusedLabelColor = Color.Black,
                cursorColor = Color.Black
            )

        )
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Número de Teléfono") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                focusedLabelColor = Color.Black,
                cursorColor = Color.Black
            )
        )

        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Dirección") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                focusedLabelColor = Color.Black,
                cursorColor = Color.Black
            )
        )

        OutlinedTextField(
            value = cardNumber,
            onValueChange = { cardNumber = it },
            label = { Text("Número de Tarjeta") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                focusedLabelColor = Color.Black,
                cursorColor = Color.Black
            )
        )
        InformationPurchace()
        Button(
            onClick = { navController.navigate(StoreScreens.SuccessfulBuy.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = mycolor)
        ) {
            Text(text = "Realizar Pago", color = Color.Black)
        }
    }
}
@Composable
fun InformationPurchace(){
    Column {
        Text(
            text = "Pantalon Jean" ,
            fontSize = 36.sp,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.padding(10.dp),
        )

        TotalPurchace("Talla: ", "M")
        TotalPurchace(text = "Color:", vari = "Azul")
        TotalPurchace(text = "Total:", vari = "$308089.0")
    }
}
@Composable
fun TotalPurchace(text: String, vari: String){
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = vari,
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black.copy(alpha = 0.4f),
            modifier = Modifier.padding(10.dp)
        )
    }
}


