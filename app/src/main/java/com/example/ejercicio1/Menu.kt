package com.example.ejercicio1

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.MoreVert



@Composable
fun MenuDesplegable(){
    val context = LocalContext.current
    var texto by remember { mutableStateOf("Ejemplo") }
    var menuDesplegable by remember { mutableStateOf(false) }
    var colorSeleccionado by remember { mutableStateOf(Color.Black) }
    var tipografiaSeleccionada by remember { mutableStateOf(FontFamily.Default) }
    var tamanoTexto by remember { mutableStateOf(16.sp) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Ingrese el mensaje") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(bottom = 16.dp)
        )

        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { menuDesplegable = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Opciones de formato")
                Spacer(Modifier.weight(1f))
                Icon(Icons.Default.ArrowDropDown, contentDescription = "Mostrar Menu")
            }
            DropdownMenu(
                expanded = menuDesplegable,
                onDismissRequest = { menuDesplegable = false },
                modifier = Modifier.width(280.dp)
            ) {
                DropdownMenuItem(
                    text = { Text("Cambiar el color") },
                    onClick = {
                        colorSeleccionado = when (colorSeleccionado) {
                            Color.Black -> Color.Blue
                            Color.Blue -> Color.Red
                            Color.Red -> Color.Green
                            Color.Green -> Color.Yellow
                            else -> Color.Black
                        }
                        Toast.makeText(context, "Color Cambiado", Toast.LENGTH_SHORT).show()
                        menuDesplegable = false
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Default.MoreVert,
                            contentDescription = "Cambiar color",
                            tint = colorSeleccionado
                        )
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Cambiar tipografía",
                            fontFamily = tipografiaSeleccionada
                        )
                    },
                    onClick = {
                        tamanoTexto = when(tamanoTexto) {
                            16.sp -> 20.sp
                            20.sp -> 24.sp
                            24.sp -> 28.sp
                            else -> 16.sp
                        }
                        tipografiaSeleccionada = when(tipografiaSeleccionada) {
                            FontFamily.Default -> FontFamily.Serif
                            FontFamily.Serif -> FontFamily.Monospace
                            FontFamily.Monospace -> FontFamily.SansSerif
                            else -> FontFamily.Default
                        }
                        Toast.makeText(context, "Tipografía cambiada", Toast.LENGTH_SHORT).show()
                        menuDesplegable = false
                    }
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(top = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = texto,
                color = colorSeleccionado,
                fontFamily = tipografiaSeleccionada,
                fontSize = tamanoTexto
            )
        }
    }

}





