package br.senai.sp.jandira.controlenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

lateinit var nota1EditText : EditText
lateinit var nota2EditText : EditText
lateinit var nomeEditText: EditText;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)
        val resultadoTextView = findViewById<TextView>(R.id.resultado)
        val relatorioTextView = findViewById<TextView>(R.id.relatorio)

        resultadoTextView.text = ""
        relatorioTextView.text = ""

        sair.setOnClickListener {
            finish()
        }

        calcular.setOnClickListener {
            nota1EditText = findViewById(R.id.nota1)
            nota2EditText = findViewById(R.id.nota2)
            nomeEditText = findViewById(R.id.nome)

            if (validarCampos()){
                val nota1 = nota1EditText.text.toString().toInt()
                val nota2 = nota2EditText.text.toString().toInt()
                val nome = nomeEditText.text.toString()


                if (nota1 > 10 || nota2 > 10) {
                    relatorioTextView.text = ""
                    resultadoTextView.text = "Nota Invalida!"
                    resultadoTextView.setTextColor(Color.RED)
                }else {
                    val media = (nota1 + nota2) / 2

                    relatorioTextView.text = "Nome : $nome\n"+
                            "Nota 1 : $nota1\n" +
                            "Nota 2 : $nota2\n" +
                            "Média : $media";

                    if (media >= 5) {
                        resultadoTextView.text = "Aprovado!\n:)"

                        resultadoTextView.setTextColor(Color.GREEN)
                    } else {
                        resultadoTextView.text = "Reprovado!\n:("

                        resultadoTextView.setTextColor(Color.RED)
                    }
                }
            }
        }
    }

    private fun validarCampos(): Boolean {
        var noError = true

        if (nota1EditText.text.isBlank()) {
            nota1EditText.setError("Digite a nota 1")
            noError = false;
        }

        if (nota2EditText.text.isBlank()) {
            nota2EditText.setError("Digite a nota 2")
            noError = false;
        }

        if (nomeEditText.text.isBlank()) {
            nomeEditText.setError("Digite a nota 2")
            noError = false;
        }

        return noError;
    }
}