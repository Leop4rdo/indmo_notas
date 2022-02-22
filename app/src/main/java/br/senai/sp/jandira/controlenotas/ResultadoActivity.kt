package br.senai.sp.jandira.controlenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val nomeTextView : TextView = findViewById(R.id.nome)
        val nota1TextView : TextView = findViewById(R.id.nota1)
        val nota2TextView : TextView = findViewById(R.id.nota2)
        val mediaTextView : TextView = findViewById(R.id.media)
        val situacaoTextView : TextView = findViewById(R.id.situacao)

//        val intent : Intent = this.intent

        val actionBar = supportActionBar
        actionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        nomeTextView.text = this.intent.getStringExtra("nome")
        nota1TextView.text = this.intent.getIntExtra("nota1", 0).toString()
        nota2TextView.text = this.intent.getIntExtra("nota2", 0).toString()
        mediaTextView.text = this.intent.getIntExtra("media", 0).toString()
        situacaoTextView.text = this.intent.getStringExtra("situacao")
    }
}