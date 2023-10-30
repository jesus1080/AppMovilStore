package com.example.appstore.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp



@Composable
fun MainScreen (){

}
@Composable
fun ScaffoldExample() {
    val mycolor = Color(0.5f, 0.5f, 0.5f, 0.2f)
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = mycolor,
                elevation = 4.dp
            ) {
                ContentTopBar()
            }
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = mycolor,
                elevation = 1.dp
            ) {
               ContentBottomBar()
            }
        },

    ) { innerPadding ->
        BodyContent(modifier = Modifier
            .padding(innerPadding))

    }
}
@Composable
fun BodyContent(modifier: Modifier){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Va el icono")
        Text(text = "Van los productos")
    }
}
@Composable
fun ContentTopBar(){
    var text by remember { mutableStateOf(TextFieldValue()) }
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
            },
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(
                    8.dp
                ),
            singleLine = true
        )
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .padding(8.dp)
        )

    }
}
@Composable
fun ContentBottomBar(){
    Row (
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .padding(8.dp)
        )
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .padding(8.dp)
        )
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .padding(8.dp)
        )
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}
@Preview
@Composable
fun PreviewMain(){
    ScaffoldExample()
}