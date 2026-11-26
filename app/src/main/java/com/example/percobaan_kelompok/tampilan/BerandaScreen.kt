package com.example.percobaan_kelompok.tampilan

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Data contoh milik layar ini sendiri (private = tidak terlihat file lain)
private val contohTransaksi = listOf(
    "Makan siang" to "Rp15.000",
    "Ojek ke kampus" to "Rp12.000",
    "Fotokopi modul" to "Rp8.000",
    "Kuota internet" to "Rp50.000"
)

// KONTRAK (jangan diubah):
// onTambah    = pindah ke layar Form
// onRingkasan = pindah ke layar Ringkasan
@Composable
fun BerandaScreen(
    onTambah: () -> Unit,
    onRingkasan: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("PocketLog", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        // Kartu saldo
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Sisa saldo")
                Text("Rp1.915.000", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }
        }

        // Dua tombol sama lebar
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = onTambah, modifier = Modifier.weight(1f)) { Text("+ Pengeluaran") }
            OutlinedButton(onClick = onRingkasan, modifier = Modifier.weight(1f)) { Text("Ringkasan") }
        }

        Text("Transaksi terbaru", fontWeight = FontWeight.SemiBold)

        // Daftar yang bisa digulir
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(contohTransaksi) { (nama, nominal) ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.padding(16.dp).fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(nama)
                        Text(nominal, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}