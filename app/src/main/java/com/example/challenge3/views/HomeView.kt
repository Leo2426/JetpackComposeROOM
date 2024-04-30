package com.example.challenge3.views
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.challenge3.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, viewModel: ProductViewModel) {
    Scaffold(
        topBar = {
           CenterAlignedTopAppBar(
                title = {
                    Text("Home")
                }
           )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("addProduct") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
                ) {

                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Product")
            }
        }
    ) {
        ContentHomeView(it, navController , viewModel)
    }
}


@Composable
fun ContentHomeView(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: ProductViewModel
) {
    val state = viewModel.state

    Column (
        modifier = Modifier.padding(paddingValues)
    ) {
       LazyColumn {
            items(state.products) {
                Box(modifier = Modifier.padding(16.dp)){
                    Column (
                        modifier = Modifier.padding(16.dp)
                    ){
                        Text(text = it.name)
                        Text(text = it.price.toString())
                        Text(text = it.description)
                    }
                }

            }
       }

        Text(text = "Home View")



    }

}
