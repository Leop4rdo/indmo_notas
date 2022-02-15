package br.senai.sp.jandira.controlenotas

fun definirSituacao(media: Int): String {
    var situacao = "";

    if (media >= 5) situacao = "Aprovado!"
    else situacao = "Reprovado!"

    return situacao;
}

//private fun calcularMedia(nota1 : Int, nota2 : Int) : Double = (nota1 + nota2) / 2.0;

fun calcularMedia(vararg notas : Int) : Int {
    var media = 0;

    for (nota in notas) {
        media += nota;
    }

    media /= notas.size;

    return media;
}