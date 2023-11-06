package com.example.appstore.navigation

sealed class StoreScreens(val route: String){
    object MainScreen: StoreScreens("main_screen")
    object ProductScreen: StoreScreens("product_screen")
    object SuccessfulBuy: StoreScreens("success_screen")
    object ToBuy: StoreScreens("buy_screen")
    object UserProfile: StoreScreens("profile_screen")
}
