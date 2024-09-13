package com.tifd.projectcomposed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    var jurusan by remember { mutableStateOf("") }
    var sapaan by remember { mutableStateOf("") }
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
                text = "Jurusan",
                color = Color.Black,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )
            TextField(
                value = jurusan,
                onValueChange = { jurusan = it },
                label = { Text("Masukkan jurusanmu") },
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

        // Tombol Submit
        Button(
            onClick = { sapaan = "Halo $nama dari jurusan $jurusan" },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.DarkGray
            )
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
