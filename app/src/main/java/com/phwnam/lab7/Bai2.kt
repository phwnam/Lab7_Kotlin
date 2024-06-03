package com.phwnam.lab7

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun PreBai2() {
    val navController = rememberNavController()
    Bai2(navController)
}

enum class Screen(val route:String){
    LOGIN("Login"),
    BAI1("Bai1"),
    SCREEN1("Screen1"),
    SCREEN2("Screen2"),
    SCREEN3("Screen3"),
}
@Composable
fun Bai2(navController: NavHostController) {
    val navController = rememberNavController()

    val mainViewModel: MainViewModel = viewModel()
    val moviesState = mainViewModel.movies.observeAsState(initial = emptyList())
    NavHost(
        navController = navController,
        startDestination = Screen.LOGIN.route,
    ){
        composable(Screen.LOGIN.route){ LoginScreen(navController) }
        composable(Screen.BAI1.route){ MovieScreen(moviesState.value) }
        composable(Screen.SCREEN2.route){ Screen2(navController)}
        composable(Screen.SCREEN3.route){ Screen3(navController)}
    }
}

@Composable
fun Screen1(navController: NavController){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .clickable {
                navController.navigate(Screen.SCREEN2.route) {
                    popUpTo(Screen.SCREEN1.route) { inclusive = true }
                }
            }
    ){
        Text(text = "Screen 1", color = Color.White, fontSize = 20.sp)
    }
}

@Composable
fun Screen2(navController: NavController){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .clickable { navController.navigate(Screen.SCREEN3.route) }
    ){
        Text(text = "Screen 2", color = Color.White, fontSize = 20.sp)
    }
}

@Composable
fun Screen3(navController: NavController){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .clickable { navController.navigate(Screen.SCREEN1.route) }
    ){
        Text(text = "Screen 3", color = Color.White, fontSize = 20.sp)
    }
}