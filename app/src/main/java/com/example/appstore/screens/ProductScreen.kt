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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appstore.R

@Composable
fun ProductScreen(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ImageProduct()
        Spacer(modifier = Modifier.heightIn(10.dp))
        DescriptionProduct()
    }
}
@Composable
fun ImageProduct(){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.producto),
            contentDescription = "producto",
            contentScale =  ContentScale.FillWidth,
            modifier = Modifier.size(500.dp)
        )

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "atras",
            tint = Color.Black,
            modifier = Modifier
                .size(50.dp)
                .padding(10.dp)
                .align(Alignment.TopStart)
        )

        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = "compartir",
            tint = Color.Black,
            modifier = Modifier
                .size(50.dp)
                .padding(10.dp)
                .align(Alignment.TopEnd)
                .clickable {  }
        )
    }
}
@Composable
fun DescriptionProduct(){
    Column {
        NameProduct("Camison")
        PriceProduct(360000f, 3)
        ProductColor()
        ProductSize()
        BuyButons()
    }
}
@Composable
fun NameProduct(name: String){
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            fontFamily = FontFamily.Cursive,
            fontSize = 36.sp,
            modifier = Modifier.padding(10.dp)
        )
        Icon(
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .padding(10.dp)
                .size(45.dp)
        )


    }
}
@Composable
fun Cualifi( qualification: Int){
    Row(
        modifier = Modifier.padding(10.dp)
    ) {
        for (i in 0 until qualification ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun PriceProduct(price: Float,qualification: Int){
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Cualifi(qualification = qualification)
        Text(
            text = "$" + String.format("%.2f", price),
            fontSize = 36.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}
@Composable
fun ProductColor(){
    Column {
        Text(
            text = "Color: ",
            fontSize = 36.sp,
            modifier = Modifier.padding(10.dp)
        )
        ColoredCircles()
    }
}
@Composable
fun ColoredCircles(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),

    ){
        ColoredCircled(color = Color.Black)
        ColoredCircled(color = Color.Gray)
        ColoredCircled(color = Color.Cyan)
    }
}
@Composable
fun ColoredCircled(color: Color){
    Box(
        modifier = Modifier
            .padding(5.dp)
            .size(40.dp)
            .background(color, shape = CircleShape)

    )
}
@Composable
fun ProductSize(){
    Column {
        Text(
            text = "Tamanio: ",
            fontSize = 36.sp,
            modifier = Modifier.padding(10.dp)
        )
        SizeOptions()
    }
}
@Composable
fun SizeOptions(){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ){
        SizeOption("S")
        SizeOption("L")
        SizeOption("M")
        SizeOption("X")
    }
}
@Composable
fun SizeOption(sizes: String){
    val mycolor = Color(0.9f, 0.8f, 0.9f, 0.4f)
    Box(
        modifier = Modifier
            .padding(5.dp)
            .size(50.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(mycolor),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = sizes,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace
        )
    }
}
@Composable
fun BuyButons(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
        ) {
            Text(text = "Comprar ahora", fontWeight = FontWeight.Bold)
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF87CEEB))
        ) {
            Text(text = "Agregar al carrito", fontWeight = FontWeight.Bold)
        }
    }
}
@Preview
@Composable
fun PreviewProduct(){
    ProductScreen()
}
@Preview
@Composable
fun PreviewSize(){
    BuyButons()
}