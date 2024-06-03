package com.phwnam.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.phwnam.lab7.Bai1
import com.phwnam.lab7.Bai2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}
@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home"){ HomeScreen(navController) }
        composable("bai1"){ Bai1(navController)}
        composable("bai2"){ Bai2(navController)}
        composable("bai3"){ Bai3(navController) }
    }
}


@Composable
fun HomeScreen(navController: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = { navController.navigate("bai1")  }) {
            Text(text = "Bài 1")
        }
        Button(onClick = { navController.navigate("bai2")  }) {
            Text(text = "Bài 2")
        }
        Button(onClick = { navController.navigate("bai3")  }) {
            Text(text = "Bài 3")
        }
    }
}

