package com.example.percobaan_kelompok.tampilan

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Nama rute (alamat tiap layar)
object Rute {
    const val BERANDA = "beranda"
    const val FORM = "form"
    const val RINGKASAN = "ringkasan"
}

@Composable
fun PocketLogApp() {
    // Pengendali perpindahan layar
    val navController = rememberNavController()

    // NavHost = daftar semua layar; startDestination = layar pertama
    NavHost(navController = navController, startDestination = Rute.BERANDA) {

        composable(Rute.BERANDA) {
            BerandaScreen(
                onTambah = { navController.navigate(Rute.FORM) },
                onRingkasan = { navController.navigate(Rute.RINGKASAN) }
            )
        }
        composable(Rute.FORM) {
            // popBackStack() = kembali ke layar sebelumnya
            FormScreen(onKembali = { navController.popBackStack() })
        }
        composable(Rute.RINGKASAN) {
            RingkasanScreen(onKembali = { navController.popBackStack() })
        }
    }
}