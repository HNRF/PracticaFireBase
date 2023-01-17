package com.example.practicae.Navigation

import com.example.practicae.Navigation.App.Create.ruta


sealed class App (val ruta:String){
    object Login: App("Login")
    object Create: App("Create")
    object Delete: App("Delete")
    object List: App("List")


}
