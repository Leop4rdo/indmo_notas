package br.senai.sp.jandira.controlenotas

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBar

lateinit var nota1EditText : EditText
lateinit var nota2EditText : EditText
lateinit var nomeEditText: EditText;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)

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

                val media = calcularMedia(nota1, nota2, 5, 10)
                val situacao = definirSituacao(media);

                val intent = Intent(this, ResultadoActivity::class.java)

                // passando valores entre activity's
                intent.putExtra("nome", nome)
                intent.putExtra("nota1", nota1)
                intent.putExtra("nota2", nota2)
                intent.putExtra("media", media)
                intent.putExtra("situacao", situacao)

                // iniciando nova activity
                startActivity(intent);

//                relatorioTextView.text = "Nome : $nome\n"+
//                        "Nota 1 : $nota1\n" +
//                        "Nota 2 : $nota2\n" +
//                        "Média : $media";
//
//                resultadoTextView.setText(definirSituacao(media));

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



    /*
     arrow Function ->
        val function = {param1: type, param2 : type -> "result"}
     */
}