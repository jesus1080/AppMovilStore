package com.example.appstore.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview



@Composable
fun MainScreen (){

}
@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Red) {
                Text(text = "Top app bar")
            }
        },
        bottomBar = {
            BottomAppBar(backgroundColor = Color.Blue) {
               Text(modifier = Modifier.fillMaxWidth(),
                   textAlign = TextAlign.Center,
                   text = "Booton app bar",
                   ) 
            }
        }
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

@Preview
@Composable
fun PreviewMain(){
    ScaffoldExample()
}