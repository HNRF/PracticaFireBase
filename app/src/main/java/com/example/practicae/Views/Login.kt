package com.example.practicae.Views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practicae.R


@Composable
fun LoginView(navController: NavHostController) {
    val fondo = painterResource(R.drawable.fondo)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color(0xFF0F222D),
        contentColor = Color.DarkGray,
        border = BorderStroke(1.dp, Color.DarkGray)
    ) {

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
                painter = painterResource(R.drawable.icono1),
                contentDescription = "Icono",
                modifier = Modifier.size(170.dp),

            )


            Text(
                text = "MaiCalendar",
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.body1

                )

            Spacer(modifier = Modifier.size(10.dp))

            Button(
                onClick = {
                    navController.navigate("Create")


                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color(0xFFBA3521)
                ),
                border = BorderStroke(1.dp, Color(0xFF51819E))
            )
            {
                Text(text = "Añadir Recordatorio")
            }

            Spacer(modifier = Modifier.size(8.dp))


            Button(
                onClick = {
                    navController.navigate("Delete")
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color(0xFFBA3521)
                ),
                border = BorderStroke(1.dp, Color(0xFF51819E))
            )
            {
                Text(text = "Borrar Recordatorio")
            }

            Spacer(modifier = Modifier.size(8.dp))

            Button(
                onClick = {
                    navController.navigate("List")
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color(0xFFBA3521)
                ),
                border = BorderStroke(1.dp, Color(0xFF51819E))
            )
            {
                Text(text = "Consultar Recordatorio")
            }

        }



    }
}




