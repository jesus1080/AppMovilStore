package com.example.appstore.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appstore.screens.MainScreen
import com.example.appstore.screens.ProductScreen
import com.example.appstore.screens.ToBuy


@Composable
fun StoreNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = StoreScreens.MainScreen.route
    ){
        composable(route = StoreScreens.MainScreen.route){
            MainScreen(navController)
        }
        composable(route = StoreScreens.ProductScreen.route + "{name}",
            arguments = listOf(navArgument(name = "name"){
                type = NavType.StringType
            })
        ){
            ProductScreen(navController, it.arguments?.getString("name"))
        }
        composable(route = StoreScreens.ToBuy.route){
            ToBuy()
        }
    }
}