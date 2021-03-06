package controller

import model.Contato
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JList
import javax.swing.JTextArea
import javax.swing.JTextField

class Salvar(
    val listaContatos: JList<Contato>,
    val campoNome: JTextField,
    val campoTelefone: JTextField,
    val campoDetalhes: JTextArea
) : KeyAdapter() {
    override fun keyReleased(e: KeyEvent) {
        val contatoSelecionado = listaContatos.selectedValue
        if (contatoSelecionado != null) {
            contatoSelecionado.nome = campoNome.text
            contatoSelecionado.telefone = campoTelefone.text
            contatoSelecionado.detalhes = campoDetalhes.text
        }
        listaContatos.repaint()
    }
}