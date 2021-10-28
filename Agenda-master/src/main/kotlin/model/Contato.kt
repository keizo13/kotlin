package model

import java.io.Serializable


class Contato : Serializable {
    var nome: String = "Novo Contato"
    var telefone: String = ""
    var detalhes: String = ""
    var endereco: String = ""
    var enderecoComercial: String = ""

    override fun toString(): String {
        return nome
    }
}