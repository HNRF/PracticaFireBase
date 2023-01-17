package com.example.practicae.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicae.Views.*


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = App.Login.ruta)
    {
        composable(App.Login.ruta) { LoginView(navController) }
        composable(App.Create.ruta){ CreateView(navController)}
        composable(App.Delete.ruta){ DeleteView(navController)}
        composable(App.List.ruta){consultar(navController)}

    }
}