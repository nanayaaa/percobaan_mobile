package com.example.percobaan_kelompok.tampilan

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// KONTRAK (jangan diubah):
// onKembali = kembali ke layar sebelumnya (dipakai tombol Simpan dan Batal)
@Composable
fun FormScreen(onKembali: () -> Unit) {
    // Isi kolom disimpan di state; tanpa ini kolom tidak bisa diketik
    var nama by remember { mutableStateOf("") }
    var nominal by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Tambah pengeluaran", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = nominal,
            onValueChange = { nominal = it },
            label = { Text("Nominal (Rp)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )


        // Sementara Simpan hanya kembali; penyimpanan data ditambah belakangan
        Button(onClick = onKembali, modifier = Modifier.fillMaxWidth()) { Text("Simpan") }
        OutlinedButton(onClick = onKembali, modifier = Modifier.fillMaxWidth()) { Text("Batal") }
    }
}