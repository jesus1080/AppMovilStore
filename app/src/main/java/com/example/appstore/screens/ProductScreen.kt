package com.example.appstore.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
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

        Image(
            painter = painterResource(R.drawable.producto),
            contentDescription = "producto",
            contentScale =  ContentScale.FillWidth,
            modifier = Modifier.size(500.dp)
        )
        Spacer(modifier = Modifier.heightIn(10.dp))
        DescriptionProduct()
    }
}

@Composable
fun DescriptionProduct(){
    Column {
        NameProduct("Camison")
        PriceProduct(360000f, 3)
        ProductColor()
        ProductSize()
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
    Box(
        modifier = Modifier
            .padding(5.dp)
            .size(50.dp)
            .clip(RectangleShape)
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = sizes,
            color = Color.White,
            fontSize = 30.sp
        )
    }
}
@Preview
@Composable
fun PreviewProduct(){
    ProductScreen()
}