package com.example.Cadastro

class Formulario(
    val nome: String,
    val telefone: String,
    val email: String,
    val ingressarNaLista: Boolean,
    val sexo: String,
    val cidade: String,
    val estado: String
) {
    override fun toString(): String {
        return "Nome: $nome\n" +
                "Telefone: $telefone\n" +
                "Email: $email\n" +
                "Ingressar na lista: $ingressarNaLista\n" +
                "Sexo: $sexo\n" +
                "Cidade: $cidade\n" +
                "Estado: $estado"
    }
}
