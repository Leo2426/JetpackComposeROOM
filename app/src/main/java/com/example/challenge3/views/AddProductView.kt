package com.example.challenge3.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.challenge3.model.Product
import com.example.challenge3.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductView(navController: NavHostController, viewModel: ProductViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Add Product")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("home") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {

                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
            }
        }
    ) {
        ContentAddProduct(it, navController , viewModel)
    }
}

@Composable
fun ContentAddProduct(
    it: PaddingValues,
    navController: NavController,
    viewModel: ProductViewModel
) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 16.dp)
            .fillMaxSize()
    ) {
        
        OutlinedTextField(value = name,
            onValueChange = {name = it},
            label = { Text("Name") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        OutlinedTextField(value = price,
            onValueChange = {price = it},
            label = { Text("Price") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        OutlinedTextField(value = description,
            onValueChange = {description = it},
            label = { Text("Description") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        
        Button(
            onClick = {
                viewModel.addProduct(Product(name = name, price = price.toDouble(), description = description))
                navController.navigate("home")

            }) {

            Text("Add Product")
        }
        
    }


}
