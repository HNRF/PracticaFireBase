package com.example.practicae.Views


import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practicae.Model.recordatorio
import com.example.practicae.R
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ListView (recordatorio: recordatorio, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        backgroundColor = Color(0xFF0F222D),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF51819E),
                            Color(0xFFBE7166),
                            Color(0xFFBA3521)

                        )
                    ),

                    )
        ) {
            Text(
                text = "Lunes:" + recordatorio.Lunes,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )
            Text(
                text = "Martes:" + recordatorio.Martes,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )
            Text(
                text = "Miércoles:" + recordatorio.Miércoles,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )
            Text(
                text = "Jueves:" + recordatorio.Jueves,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )
            Text(
                text = "Viernes:" + recordatorio.Viernes,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )
            Text(
                text = "Sábado:" + recordatorio.Sábado,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )
            Text(
                text = "Domingo:" + recordatorio.Domingo,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                color = Color.White
            )

        }
    }

}

@Composable
fun consultar(navController: NavHostController){
    val db = FirebaseFirestore.getInstance()
    val fondo = painterResource(R.drawable.fondo)
    val logo = painterResource(R.drawable.icono2)
    var Recordatorio_coleccion = "recordatorio"


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .paint(painter = fondo,contentScale = ContentScale.FillBounds)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Image(
                painter = logo,
                contentDescription = null
            )
            Text(
                text = "Consultar Calendario",
                color = Color(0xFFBA3521),
                fontSize = 35.sp
            )

                    var lista by remember { mutableStateOf(listOf<recordatorio>()) }
                    var datos by remember { mutableStateOf("") }

                    Button(
                        onClick = {
                            db.collection(Recordatorio_coleccion)
                                .get()
                                .addOnSuccessListener { rs ->
                                    for (encontrado in rs) {
                                        lista += recordatorio(
                                            encontrado["Semana"].toString(),
                                            encontrado["Lunes"].toString(),
                                            encontrado["Martes"].toString(),
                                            encontrado["Miércoles"].toString(),
                                            encontrado["Jueves"].toString(),
                                            encontrado["Viernes"].toString(),
                                            encontrado["Sábado"].toString(),
                                            encontrado["Domingo"].toString(),

                                            )
                                    }

                                    datos += lista.toString()
                                    if (datos.isEmpty()) {
                                        datos = "No existen datos"
                                    }
                                }
                                .addOnFailureListener { rs ->
                                    datos = "Fallo en la conexion"
                                    Log.i(ContentValues.TAG, "Error:", rs)
                                }
                        },

                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent,
                            contentColor = Color(0xFFBA3521)
                        ),
                        border = BorderStroke(1.dp, Color(0xFF51819E))
                    ) {

                        Text(
                            text = "Cargar Calendario",
                            color = Color(0xFFBA3521),
                            fontSize = 16.sp

                        )

                    }
                    recordatoriolista(navController = navController, lista)
                }

            }
        }


@Composable
fun listaCalendario (navController: NavHostController, lista: List<recordatorio>){
    LazyColumn(

    ){
        items(lista) { recordatorio ->
            ListView(recordatorio, navController = navController)
        }

    }

}


@Composable
fun recordatoriolista (navController: NavHostController, lista: List<recordatorio>){

    Column() {
        listaCalendario(lista = lista, navController = navController)
        Log.w("Datos",lista.toString())
    }

}






