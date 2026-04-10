package com.example.sielistasnavegacion.sie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.sielistasnavegacion.ui.theme.SieListasNavegacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SieListasNavegacionTheme {
                AppNavigation()

            }
        }
    }
}