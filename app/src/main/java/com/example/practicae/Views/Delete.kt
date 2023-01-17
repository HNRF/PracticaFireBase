package com.example.practicae.Views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practicae.R
import com.example.practicae.ui.theme.PracticaETheme
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun DeleteView (navController: NavHostController) {

    val db = FirebaseFirestore.getInstance()
    val fondo = painterResource(R.drawable.fondo)
    var Recordatorio_coleccion = "recordatorio"

    var Semana by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
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
                .paint(painter = fondo,contentScale = ContentScale.FillBounds)

        ) {

            Image(
                painter = painterResource(R.drawable.icono2),
                contentDescription = null
            )
            Text(
                text = "Eliminar cliente",
                fontWeight = FontWeight.ExtraBold
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = Semana,
                onValueChange = { Semana = it },
                label = {
                    Text(text = "Domingo")
                },

            )

            var mensaje_borrado by remember { mutableStateOf("") }

            Button(
                onClick = {
                    if (Semana.isNotBlank()) {
                    db.collection(Recordatorio_coleccion)
                        .document(Semana)
                        .delete()
                        .addOnSuccessListener {
                            mensaje_borrado = "Los datos se han elimnado correctamente"
                            Semana = ""
                        }
                        .addOnFailureListener{
                            mensaje_borrado = "ERROR"
                            Semana = ""
                        }
                }

                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color(0xFFBA3521)
                ),
                border = BorderStroke(1.dp, Color(0xFF51819E))
            )
            {
                Text(text = "Borrar")
            }
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = mensaje_borrado)
        }
    }
}
