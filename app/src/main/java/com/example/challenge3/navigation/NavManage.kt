package com.example.challenge3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.challenge3.viewmodel.ProductViewModel
import com.example.challenge3.views.AddProductView
import com.example.challenge3.views.HomeView

@Composable
fun NavManage(viewModel: ProductViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeView(navController, viewModel)
        }

        composable("addProduct") {
            AddProductView(navController, viewModel)
        }




    }
}