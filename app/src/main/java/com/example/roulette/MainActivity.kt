package com.example.roulette

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pega referência do edit text por id
        val editTextNumber = findViewById<EditText>(R.id.et_number)

        // Define minimo e maximo do edit text
        editTextNumber.filters = arrayOf<InputFilter>(MinMaxFilter(1, 10))

        // Pega referência do button por id
        val btnRodar = findViewById<Button>(R.id.btn_rodar)


        // Ouvinte para click no botão rodar
        btnRodar.setOnClickListener {

            // Pega referência do textView por id
            val texto = findViewById<TextView>(R.id.tv_sorteio)

            // Pega um número inteiro random
            val numeroSorteado = Random().nextInt(11)

            // Compara valor inserido com o valor sorteado
            if (editTextNumber.text.toString() == numeroSorteado.toString()) {
                // Exibe mensagem de parabenização caso números iguais
                texto.text = "Parabéns! Você acertou!"
            } else {
                // Exibe erro caso não números diferentes
                texto.text = "Não foi dessa vez!!! Tente novamente!!!"
            }

        }
    }

    // Custom class to define min and max for the edit text
    inner class MinMaxFilter() : InputFilter {
        private var intMin: Int = 0
        private var intMax: Int = 0

        // Initialized
        constructor(minValue: Int, maxValue: Int) : this() {
            this.intMin = minValue
            this.intMax = maxValue
        }

        override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned, dStart: Int, dEnd: Int): CharSequence? {
            try {
                val input = Integer.parseInt(dest.toString() + source.toString())
                if (isInRange(intMin, intMax, input)) {
                    return null
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
            return ""
        }

        // Check if input c is in between min a and max b and
        // returns corresponding boolean
        private fun isInRange(a: Int, b: Int, c: Int): Boolean {
            return if (b > a) c in a..b else c in b..a
        }
    }
}