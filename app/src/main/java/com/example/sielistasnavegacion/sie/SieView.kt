package com.example.sielistasnavegacion.sie

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.sielistasnavegacion.ui.theme.SieListasNavegacionTheme
import kotlinx.serialization.Serializable

// --- DEFINICIÓN DE RUTAS ---

@Serializable
object Login

@Serializable
object ListaAlumnos

@Serializable
data class PerfilAlumno(val idAlumno: Int, val esCoordinador: Boolean)

@Serializable
data class DetalleMateria(
    val nombre: String, 
    val faltas: Int, 
    val calificacion: String // Cambiado a String para evitar errores de NavType
)

// --- NAV MANAGER ---

@Composable
fun SieNavManager() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Login
    ) {
        // 1. Pantalla de Login
        composable<Login> {
            LoginScreen(navController)
        }

        // 2. Pantalla de Lista de Alumnos (Coordinadores)
        composable<ListaAlumnos> {
            ListaAlumnosScreen(navController)
        }

        // 3. Perfil Alumno
        composable<PerfilAlumno> {
            val datos: PerfilAlumno = it.toRoute()
            PerfilAlumnoScreen(navController, datos)
        }

        // 4. Detalle Materia
        composable<DetalleMateria> {
            val datos: DetalleMateria = it.toRoute()
            DetalleMateriaScreen(navController, datos)
        }
    }
}

// --- PREVIEWS ---

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SieAppPreview() {
    SieListasNavegacionTheme {
        SieNavManager()
    }
}

@Preview(showBackground = true, name = "Perfil Estudiante")
@Composable
fun PerfilPreview() {
    SieListasNavegacionTheme {
        val nav = rememberNavController()
        PerfilAlumnoScreen(nav, PerfilAlumno(20050, true))
    }
}
