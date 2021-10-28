package model

import java.io.Serializable


class Contato : Serializable {
    var nome: String = "Novo Contato"
    var telefone: String = ""
    var detalhes: String = ""

    override fun toString(): String {
        return nome
    }
}