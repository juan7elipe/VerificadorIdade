package br.unipar.verificadoridade

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Dizer qual tela vai ser carregada
        setContentView(R.layout.activity_main)

        val resultado = findViewById<TextView>(R.id.txtResultado)
        val inputIdade = findViewById<EditText>(R.id.edIdade)
        val botaoValidar = findViewById<Button>(R.id.btnIdade)

        botaoValidar.setOnClickListener {
            // Pega o valor do input da tela
            val idadeInformada = inputIdade.text.toString()

            if (idadeInformada.isNotEmpty()) {
                val idadeInt = idadeInformada.toInt()

                if (idadeInt < 18) {
                    resultado.text = "Você é menor de idade."
                } else if (idadeInt in 18..60) {
                    resultado.text = "Você está na meia idade."
                } else if (idadeInt >= 60) {
                    resultado.text = "Você é idoso."
                } else {
                    resultado.text = "Digite um valor válido."
                }
            }
        }
    }

        fun limparValores(view: View) {
            val resultado = findViewById<TextView>(R.id.txtResultado)
            val input = findViewById<EditText>(R.id.edIdade)

            resultado.setText("")
            input.setText("")
        }
    }
