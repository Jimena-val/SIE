package com.example.sielistasnavegacion.sie

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DetalleMateriaScreen(
    navController: NavController,
    datos: DetalleMateria
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = datos.nombre,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(30.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Faltas", color = Color.Gray, fontSize = 16.sp)
                Text(
                    text = "${datos.faltas}",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (datos.faltas > 3) Color.Red else Color.Black
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Calificación", color = Color.Gray, fontSize = 16.sp)
                Text(
                    text = datos.calificacion,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = if ((datos.calificacion.toDoubleOrNull() ?: 0.0) >= 9.0) Color(0xFF4CAF50) else Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(60.dp))
        
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Regresar")
        }
    }
}
