package com.example.sielistasnavegacion.sie
import com.example.sielistasnavegacion.R

data class Materia(
    val nombre: String,
    val faltas: Int,
    val calificacion: Double
)

data class Alumno(
    val id: Int,
    val nombre: String,
    val correo: String,
    val carrera: String,
    val pasatiempo: String,
    val promedio: Double,
    val materias: List<Materia>,
    val avatar: Int
)

val materiasEjemplo = listOf(
    Materia("Programación", 2, 9.5),
    Materia("Base de Datos", 1, 8.7),
    Materia("Redes", 0, 9.0)
)

val alumnos = List(10) { index ->
    Alumno(
        id = 20050 + index,
        nombre = "Alumno ${index + 1}",
        correo = "alumno${index + 1}@correo.com",
        carrera = "Ing. Sistemas",
        pasatiempo = "Deporte",
        promedio = 9.0,
        materias = materiasEjemplo,
        avatar = R.drawable.avatar
    )
}