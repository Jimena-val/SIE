package com.example.listaspeoductos.sie.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {

    var nombre by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Sistema S.I.E",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 🔹 Nombre
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 🔹 ID
        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("ID") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val idNumero = id.toIntOrNull()

                if (idNumero != null) {

                    when {
                        idNumero in 1..10 -> {
                            navController.navigate("lista_alumnos")
                        }

                        idNumero in 20050..20200 -> {
                            navController.navigate("materias_alumno/$idNumero")
                        }

                        else -> {
                            error = "ID no válido"
                        }
                    }

                } else {
                    error = "Ingresa un ID numérico"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar")
        }

        if (error.isNotEmpty()) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}