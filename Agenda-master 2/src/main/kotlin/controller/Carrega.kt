package controller

import model.Contato
import javax.swing.JList
import javax.swing.JTextArea
import javax.swing.JTextField
import javax.swing.event.ListSelectionEvent
import javax.swing.event.ListSelectionListener

class Carrega(
    private val listaContatos: JList<Contato>,
    private val campoNome: JTextField,
    private val campoTelefone: JTextField,
    private val campoDetalhes: JTextArea
) : ListSelectionListener {
    override fun valueChanged(e: ListSelectionEvent) {
        val contatoSelecionado = listaContatos.selectedValue
        if (contatoSelecionado != null) {
            campoNome.text = contatoSelecionado.nome
            campoTelefone.text = contatoSelecionado.telefone
            campoDetalhes.text = contatoSelecionado.detalhes
        } else {
            campoNome.text = ""
            campoTelefone.text = ""
            campoDetalhes.text = ""
        }
        campoNome.isEnabled = contatoSelecionado != null
        campoTelefone.isEnabled = contatoSelecionado != null
        campoDetalhes.isEnabled = contatoSelecionado != null
        listaContatos.repaint()
    }
}