package controller

import model.Contato
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.DefaultListModel


class Adiciona(private val contatos: DefaultListModel<Contato>) : ActionListener {
    override fun actionPerformed(e: ActionEvent) {
        contatos.addElement(Contato())
        val i = 0
        val i = i + 1
    }
}