package com.example.challenge3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.challenge3.navigation.NavManage
import com.example.challenge3.room.ProductsDataBase
import com.example.challenge3.ui.theme.Challenge3Theme
import com.example.challenge3.viewmodel.ProductViewModel
import com.example.challenge3.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Challenge3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    val database = Room.databaseBuilder(
                        this,
                        ProductsDataBase::class.java,
                        "products_database"
                    ).build()

                    val dao = database.productDao()

                    val viewModel = ProductViewModel(dao)

                    NavManage(viewModel = viewModel)


                }
            }
        }
    }
}



