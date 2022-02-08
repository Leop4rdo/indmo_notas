package br.senai.sp.jandira.controlenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)
        val resultado = findViewById<TextView>(R.id.resultado)
        val relatorio = findViewById<TextView>(R.id.relatorio)

        resultado.text = ""
        relatorio.text = ""

        sair.setOnClickListener {
            finish()
        }

        calcular.setOnClickListener {
            val nota1 = findViewById<EditText>(R.id.nota1).text.toString().toInt()
            val nota2 = findViewById<EditText>(R.id.nota2).text.toString().toInt()
            val faltas = findViewById<EditText>(R.id.faltas).text.toString().toInt()

            if (nota1 > 10 || nota2 > 10) {
                relatorio.text = ""
                resultado.text = "Nota Invalida!"
                resultado.setTextColor(Color.RED)
            }else {
                val media = (nota1 + nota2) / 2

                relatorio.text = "Nota 1 : $nota1\n" +
                        "Nota 2 : $nota2\n" +
                        "Média : $media\n" +
                        "Faltas : $faltas";

                if (media >= 5) {
                    resultado.text = "Aprovado!\n:)"

                    resultado.setTextColor(Color.GREEN)
                } else {
                    resultado.text = "Reprovado!\n:("

                    resultado.setTextColor(Color.RED)
                }
            }
        }
    }
}