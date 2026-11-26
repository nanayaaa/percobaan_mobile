package com.example.percobaan_kelompok.tampilan

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Data contoh milik layar ini sendiri: kategori dan bagian (0.0 - 1.0)
private val contohKategori = listOf(
    Triple("Makan", "Rp15.000", 0.18f),
    Triple("Transport", "Rp12.000", 0.14f),
    Triple("Kuliah", "Rp8.000", 0.09f),
    Triple("Lainnya", "Rp50.000", 0.59f)
)

// KONTRAK (jangan diubah):
// onKembali = kembali ke layar sebelumnya
@Composable
fun RingkasanScreen(onKembali: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Ringkasan", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Total pengeluaran")
                Text("Rp85.000", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }
        }

        // Satu blok per kategori: nama + jumlah, lalu batang progres
        for ((nama, jumlah, bagian) in contohKategori) {
            Column {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(nama, fontWeight = FontWeight.SemiBold)
                    Text(jumlah)
                }
                Spacer(Modifier.height(6.dp))
                LinearProgressIndicator(progress = { bagian }, modifier = Modifier.fillMaxWidth())
            }
        }

        Spacer(Modifier.weight(1f))
        Button(onClick = onKembali, modifier = Modifier.fillMaxWidth()) { Text("Kembali ke beranda") }
    }
}