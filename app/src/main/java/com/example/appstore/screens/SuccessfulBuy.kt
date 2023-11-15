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