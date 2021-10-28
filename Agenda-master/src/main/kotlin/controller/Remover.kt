package controller

import model.Contato
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.DefaultListModel
import javax.swing.JList

class Remover(val listaContatos: JList<Contato>, val contatos: DefaultListModel<Contato>) : ActionListener {
    override fun actionPerformed(e: ActionEvent) {
        val contatoSelecionado = listaContatos.selectedValue
        contatos.removeElement(contatoSelecionado)
    }
}