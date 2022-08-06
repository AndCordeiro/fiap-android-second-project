package com.example.roulette

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pega referência do button por id
        val btn_rodar = findViewById(R.id.btn_rodar) as Button

        // Ouvinte para click no botão rodar
        btn_rodar.setOnClickListener {
            // Pega referência do textView por id
            var texto = findViewById<TextView>(R.id.tv_sorteio)

            // Pega um número inteiro random
            var numeroSorteado = Random().nextInt(11)

            // Exibe o resultado no textView
            texto.text = "Número sorteado é: " + numeroSorteado
        }
    }
}