package com.example.appstore.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appstore.R

@Composable
fun UserProfile(navController: NavController){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeadProfile(navController)
        ImageProfile()
        Spacer(modifier = Modifier.height(16.dp))
        ActivitiesProfile()
        InformationUser()
    }
}
@Composable
fun HeadProfile(navController: NavController){
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
        Spacer(modifier = Modifier.widthIn(70.dp))
        Text(
            text = "Mi Cuenta",
            fontFamily = FontFamily.Cursive,
            fontSize = 36.sp,
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun ImageProfile(){
    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.background)
    ){
        Image(
            painterResource(R.drawable.pepito),
            contentDescription = "profile",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
@Composable
fun ActivitiesProfile(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Actividad", style = MaterialTheme.typography.h5,modifier = Modifier.padding(5.dp))
        ActivityPro()
    }
}
@Composable
fun ActivityPro(){
    val mycolor = Color(0.9f, 0.8f, 0.9f, 1.0f)
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(5.dp)
                .size(110.dp, 50.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(mycolor),
            contentAlignment = Alignment.Center
        ){
            Row {
                Icon(Icons.Default.Face, "Detalles")
                Text(text = "Detalles", style = MaterialTheme.typography.body2)
            }
        }
        Box(
            modifier = Modifier
                .padding(5.dp)
                .size(110.dp, 50.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(mycolor),
            contentAlignment = Alignment.Center
        ){
            Row {
                Icon(Icons.Default.DateRange, "Detalles")
                Text(text = "Compras", style = MaterialTheme.typography.body2)
            }

        }
        Box(
            modifier = Modifier
                .padding(5.dp)
                .size(110.dp, 50.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(mycolor),
            contentAlignment = Alignment.Center
        ){
            Row {
                Icon(Icons.Default.FavoriteBorder, "Detalles")
                Text(text = "Favoritos", style = MaterialTheme.typography.body2)
            }


        }
    }
}
@Composable
fun InformationUser(){
    val mycolor = Color(0.9f, 0.8f, 0.9f, 1.0f)
    Column(
        modifier = Modifier.fillMaxSize().padding(25.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Informacion de la cuenta", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Nombre:   Pepito", style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Email:       pepito@mail.com", style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Telefono:  3225899999", style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Ocupacion:  Comprador", style = MaterialTheme.typography.body2)
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                ,
            colors = ButtonDefaults.buttonColors(backgroundColor = mycolor)
        ) {
            Text(text = "Editar Cuenta", color = Color.Black)
        }
    }

}

