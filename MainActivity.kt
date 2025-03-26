package com.example.calculadoraapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculadora()
        }
    }
}

@Composable
fun Calculadora() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF22252D))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        
        Text(
            text = "Aca va el resultado",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Teclado de la calculadora
        val botones = listOf(
            listOf("AC","()","%", "√"),
            listOf("7", "8", "9", "÷"),
            listOf("4", "5", "6", "×"),
            listOf("1", "2", "3", "−"),
            listOf("0", ".", "=", "+")
        )

        Column {
            botones.forEach { fila ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    fila.forEach { texto ->
                        BotonCalculadora(texto, Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun BotonCalculadora(texto: String, modifier: Modifier) {
    Button(
        onClick = { },
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            containerColor = when {
                texto == "=" -> Color(0xFF00C853)
                texto in listOf("+", "−", "×", "÷", "AC", "()", "%", "√") -> Color(0xFFFFA500)
                else -> Color(0xFF33363F)
            }
        ),
        modifier = modifier
            .padding(8.dp)
            .aspectRatio(1f)
    ) {
        Text(
            text = texto,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}