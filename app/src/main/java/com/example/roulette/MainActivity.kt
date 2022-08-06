package com.example.roulette

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pega referência do button por id
        val btnRodar = findViewById<Button>(R.id.btn_rodar)

        // Ouvinte para click no botão rodar
        btnRodar.setOnClickListener {
            // Pega referência do textView por id
            val texto = findViewById<TextView>(R.id.tv_sorteio)

            // Pega um número inteiro random
            val numeroSorteado = Random().nextInt(11)

            // Exibe o resultado no textView
            texto.text = "Número sorteado é: $numeroSorteado"
        }
    }
}