package com.example.practicae.Views


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practicae.R
import com.example.practicae.ui.theme.Red100
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun CreateView(navController: NavHostController) {

    val db = FirebaseFirestore.getInstance()

    val fondo = painterResource(R.drawable.fondo)

    var Recordatorio_coleccion = "recordatorio"
    var Semana by remember { mutableStateOf("") }
    var Lunes by remember { mutableStateOf("") }
    var Martes by remember { mutableStateOf("") }
    var Miércoles by remember { mutableStateOf("") }
    var Jueves by remember { mutableStateOf("") }
    var Viernes by remember { mutableStateOf("") }
    var Sábado by remember { mutableStateOf("") }
    var Domingo by remember { mutableStateOf("") }


    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color(0xFF0F222D),
        contentColor = Color.DarkGray,
        border = BorderStroke(1.dp, Color.DarkGray)
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 25.dp)
                .padding(start = 10.dp)
                .padding(end = 10.dp)
                .paint(painter = fondo, contentScale = ContentScale.FillBounds)

        ) {

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),

                value = Semana,
                onValueChange = { Semana = it },
                label = {
                    Text(text = "Semana:  del mes:  ")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),

                value = Lunes,
                onValueChange = { Lunes = it },
                label = {
                    Text(text = "Lunes ")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = Martes,
                onValueChange = { Martes = it },
                label = {
                    Text(text = "Martes")
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = Miércoles,
                onValueChange = { Miércoles = it },
                label = {
                    Text(text = "Miércoles")
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = Jueves,
                onValueChange = { Jueves = it },
                label = {
                    Text(text = "Jueves")
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = Viernes,
                onValueChange = { Viernes = it },
                label = {
                    Text(text = "Viernes")
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = Sábado,
                onValueChange = { Sábado = it },
                label = {
                    Text(text = "Sábado")
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = Domingo,
                onValueChange = { Domingo = it },
                label = {
                    Text(text = "Domingo")
                },

                )

            val dato = hashMapOf(
                "Semana" to Semana.toString(),
                "Lunes" to Lunes.toString(),
                "Martes" to Martes.toString(),
                "Miércoles" to Miércoles.toString(),
                "Jueves" to Jueves.toString(),
                "Viernes" to Viernes.toString(),
                "Sábado" to Sábado.toString(),
                "Domingo" to Domingo.toString()
            )
            var mensaje_confirmacion by remember { mutableStateOf("") }

            Column {
                Button(
                    onClick = {
                        db.collection(Recordatorio_coleccion)
                            .document(Semana)
                            .set(dato)
                            .addOnSuccessListener {
                                mensaje_confirmacion = "Datos guardados correctamente"
                                Semana = ""
                                Lunes = ""
                                Martes = ""
                                Miércoles = ""
                                Jueves = ""
                                Viernes = ""
                                Sábado = ""
                                Domingo = ""
                            }
                            .addOnFailureListener {
                                mensaje_confirmacion = "No se ha podido guardar"
                                Semana = ""
                                Lunes = ""
                                Martes = ""
                                Miércoles = ""
                                Jueves = ""
                                Viernes = ""
                                Sábado = ""
                                Domingo = ""
                            }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.CenterHorizontally),

                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = Color(0xFFBA3521)
                    )
                ) {

                    Text(text = "Añadir nuevo recordatorio")

                }


                Column {
                    Button(
                        onClick = { navController.navigate("List") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally),

                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent,
                            contentColor = Color(0xFFBA3521)
                        )
                    ) {
                        Text(
                            text = "Ver recordatorios"
                        )

                    }
                }

                Column {
                    Button(
                        onClick = { navController.navigate("Login") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally),

                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent,
                            contentColor = Color(0xFFBA3521)
                        )
                    ) {
                        Text(
                            text = "Ir a menu"
                        )

                    }
                }
            }

        }
    }
}







