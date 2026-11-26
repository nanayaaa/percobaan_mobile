package com.example.percobaan_kelompok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.percobaan_kelompok.tampilan.PocketLogApp
import com.example.percobaan_kelompok.ui.theme.Percobaan_KelompokTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Percobaan_KelompokTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // innerPadding agar isi tidak tertutup status bar
                    Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                        PocketLogApp()   // layar pertama = Beranda, diatur oleh NavHost
                    }
                }
            }
        }
    }
}