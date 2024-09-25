package com.tifd.projectcomposed

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tifd.projectcomposed.ui.theme.ProjectComposeDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectComposeDTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}


@Composable
fun MyScreen() {
    var nama by remember { mutableStateOf("") }
    var NIM by remember { mutableStateOf("") }
    var sapaan by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Aplikasi penyapa",
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Menggunakan Row untuk form Nama
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Nama",
                color = Color.Black,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )
            TextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Masukkan namamu") },
                modifier = Modifier.weight(2f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Menggunakan Row untuk form Jurusan
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "NIM",
                color = Color.Black,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )
            TextField(
                value = NIM,
                onValueChange = { NIM = it },
                label = { Text("Masukkan NIM-Mu") },
                modifier = Modifier.weight(2f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Teks sapaan
        Text(
            text = sapaan,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Submit yang akan disable jika form kosong
        Button(
            onClick = { sapaan = "Halo $nama dengan NIM $NIM" },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (nama.isNotEmpty() && NIM.isNotEmpty()) Color.Cyan else Color.Gray,
                contentColor = Color.DarkGray
            ),
            enabled = nama.isNotEmpty() && NIM.isNotEmpty(),
            modifier = Modifier.pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        Toast.makeText(context, "Nama: $nama, Jurusan: $NIM", Toast.LENGTH_LONG).show()
                    }
                )
            }
        ) {
            Text("Submit")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjectComposeDTheme {
        MyScreen()
    }
}
