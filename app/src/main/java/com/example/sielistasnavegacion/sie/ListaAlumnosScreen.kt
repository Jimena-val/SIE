package com.example.sielistasnavegacion.sie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sielistasnavegacion.R

@Composable
fun ListaAlumnosScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "Lista de Estudiantes",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(alumnos) { index, alumno ->
                val backgroundColor = if (index % 2 == 0) Color(0xFFF9F1D8) else Color(0xFFF2F2F2)
                
                ItemAlumno(alumno, index + 1, backgroundColor, navController)
            }
        }
    }
}

@Composable
fun ItemAlumno(alumno: Alumno, numero: Int, fondo: Color, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(fondo)
            .clickable {
                // Al hacer clic, vamos al perfil con esCoordinador = true
                navController.navigate(PerfilAlumno(idAlumno = alumno.id, esCoordinador = true))
            }
            .padding(16.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .background(Color.White, RoundedCornerShape(4.dp))
                        .padding(2.dp)
                ) {
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "$numero", fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF98D8EF)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentDescription = "Avatar",
                        modifier = Modifier.size(50.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "${alumno.id} | ${alumno.nombre.uppercase()}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Text(
                        text = alumno.correo,
                        color = Color(0xFFD4A017),
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Licenciatura en ${alumno.carrera} (Plan 2020)",
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}
