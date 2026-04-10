package com.example.sielistasnavegacion.sie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PerfilAlumnoScreen(
    navController: NavController,
    datos: PerfilAlumno
) {
    // Buscamos al alumno por su ID en la lista de Models.kt usando el ID de los datos
    val alumno = alumnos.find { it.id == datos.idAlumno } ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Perfil del Estudiante",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(20.dp))

        // Card de Información General
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF2F2F2), RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column {
                Text(text = alumno.nombre, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "ID: ${alumno.id}")
                // Agregamos el correo
                Text(text = alumno.correo, color = Color(0xFFD4A017))
                Text(text = "Carrera: ${alumno.carrera}")
                
                // Estos datos solo se muestran si el que entró es Coordinador
                if (datos.esCoordinador) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Pasatiempo: ${alumno.pasatiempo}")
                    Text(text = "Promedio: ${alumno.promedio}", color = Color.Blue, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Materias en Curso", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))

        // Lista de Materias (Cada una es un botón para ir al detalle)
        alumno.materias.forEach { materia ->
            Button(
                onClick = { 
                    // Creamos el objeto DetalleMateria para navegar
                    navController.navigate(DetalleMateria(materia.nombre, materia.faltas, materia.calificacion))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF98D8EF))
            ) {
                Text(text = materia.nombre, color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        
        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar")
        }
    }
}
