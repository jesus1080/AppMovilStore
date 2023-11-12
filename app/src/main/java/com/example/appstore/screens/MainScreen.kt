package com.example.appstore.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appstore.R
import com.example.appstore.navigation.StoreScreens


data class MyProduct(val name: String, val price: Float, val qualification: Int)

val products: List<MyProduct> = listOf(
    MyProduct("Pantalon", 345000.0f, 2),
    MyProduct("Camiseta", 87000f,5),
    MyProduct("Zapatos", 89000.0f, 1),
    MyProduct("Pantalon", 345000.0f, 2),
    MyProduct("Pantalon", 345000.0f, 3),
    MyProduct("Pantalon", 345000.0f, 4)
)
@Composable
fun MainScreen (navController: NavController) {
    val mycolor = Color(0.9f, 0.8f, 0.9f, 1.0f)
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
            .padding(innerPadding), navController)

    }
}
@Composable
fun BodyContent(modifier: Modifier,navController: NavController){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyIcon()
        Text(
                text = "Productos:",
                fontSize = 25.sp,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.padding(8.dp)
            )
        ProductList(products = products,navController)
        Spacer(modifier = Modifier.heightIn(50.dp))
    }
}

@Composable
fun MyIcon(){
    Image(
        painter = painterResource(R.drawable.logo_gys),
        contentDescription = "Logo de la empresa",
        modifier = Modifier
            .size(150.dp)
            .padding(15.dp)
    )
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
@Composable
fun ProductList(products: List<MyProduct>,navController: NavController){
    products.forEach { product ->
        Product(product = product,navController)
    }
}
@Composable
fun Product(product: MyProduct,navController: NavController){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),

        horizontalArrangement = Arrangement.Start,
    ) {
        Image(
            painter = painterResource(R.drawable.producto),
            contentDescription = "producto",
            modifier = Modifier
                .size(150.dp, 200.dp)
                .clip(RoundedCornerShape(25.dp))
                .clickable(true, onClick = {
                    navController.navigate(route = StoreScreens.ProductScreen.route + product.name)
                })

        )
        DescriptionProduct(product)
    }
}
@Composable
fun Qualifi(qualification: Int){
    Row {
        for (i in 0 until qualification ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }

}
@Composable
fun PriceIcon(price: Float){
    Row {
        Text(text = "$" + String.format("%.2f", price))
        Spacer(modifier = Modifier.widthIn(50.dp))
        Icon(
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = null,
            tint = Color.Black
        )

    }
}
@Composable
fun DescriptionProduct(product: MyProduct){
    Column {
        PriceIcon(price = product.price)
        Text(text = product.name, fontFamily = FontFamily.Cursive, fontSize = 18.sp)
        Spacer(modifier = Modifier.heightIn(130.dp))
        Qualifi(product.qualification)
    }
}


