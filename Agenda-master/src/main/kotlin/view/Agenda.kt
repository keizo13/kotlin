package view

import controller.*
import model.Contato
import java.awt.BorderLayout
import java.awt.GridLayout
import javax.swing.*


class Agenda : JFrame("Agenda") {
    private val contatos = DefaultListModel<Contato>()
    private val listaContatos = JList(contatos)
    private val campoNome = JTextField()
    private val campoTelefone = JTextField()
    private val campoEndereco = JTextField()
    private val campoEnderecoComercial = JTextField()
    private val campoDetalhes = JTextArea()

    private fun montaJanela() {
        // Criando um painel com a lista de contatos
        val painelLista = JPanel(BorderLayout())
        painelLista.border = BorderFactory.createTitledBorder("Contatos: ${i}")
        listaContatos.selectionMode = ListSelectionModel.SINGLE_SELECTION
        painelLista.add(JScrollPane(listaContatos), BorderLayout.CENTER)

        // Criando um painel com os botões sob a lista
        val botaoAdicionar = JButton("ADICIONAR")
        val botaoRemover = JButton("REMOVER")
        val painelBotoes = JPanel(GridLayout(1, 2))
        painelBotoes.add(botaoAdicionar)
        painelBotoes.add(botaoRemover)
        painelLista.add(painelBotoes, BorderLayout.SOUTH)

        // Criando um painel com o nome
        val painelNome = JPanel(BorderLayout())
        painelNome.add(JLabel("Nome:"), BorderLayout.WEST)
        campoNome.isEnabled = false
        painelNome.add(campoNome, BorderLayout.CENTER)

        // Criando um painel com o telefone
        val painelTelefone = JPanel(BorderLayout())
        painelTelefone.add(JLabel("Telefone:"), BorderLayout.WEST)
        campoTelefone.isEnabled = false
        painelTelefone.add(campoTelefone, BorderLayout.CENTER)

        val painelEndereco = JPanel(BorderLayout())
        painelEndereco.add(JLabel("Endereço:"), BorderLayout.WEST)
        campoEndereco.isEnabled = false
        painelEndereco.add(campoEndereco, BorderLayout.CENTER)

        val painelEnderecoComercial = JPanel(BorderLayout())
        painelEnderecoComercial.add(JLabel("Endereço C.:"), BorderLayout.WEST)
        campoEnderecoComercial.isEnabled = false
        painelEnderecoComercial.add(campoEnderecoComercial, BorderLayout.CENTER)
        // Criando um painel que contem tanto o nome quanto o telefone
        val painelCampos = JPanel(GridLayout(2, 1))
        painelCampos.add(painelNome)
        painelCampos.add(painelTelefone)
        painelCampos.add(painelEndereco)
        painelCampos.add(painelEnderecoComercial)

        // Criando um painel com os detalhes
        val painelDetalhes = JPanel(BorderLayout())
        painelDetalhes.border = BorderFactory.createTitledBorder("Detalhes")
        campoDetalhes.isEnabled = false
        painelDetalhes.add(JScrollPane(campoDetalhes), BorderLayout.CENTER)

        // Criando um painel central que combina os campos de texto, a área de texto e os botões
        val painelCentral = JPanel(BorderLayout())
        painelCentral.add(painelCampos, BorderLayout.NORTH)
        painelCentral.add(painelDetalhes, BorderLayout.CENTER)

        // Criando um painel do tipo split, que combina a lista com os demais componentes
        val painelPrincipal = JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, painelLista, painelCentral)
        painelPrincipal.dividerLocation = 200
        this.contentPane = painelPrincipal

        // Configurando os listeners
        listaContatos.addListSelectionListener(Carrega(listaContatos, campoNome, campoTelefone, campoDetalhes, campoEndereco, campoEnderecoComercial))
        botaoAdicionar.addActionListener(Adiciona(contatos))
        botaoRemover.addActionListener(Remover(listaContatos, contatos))
        val salvar = Salvar(listaContatos, campoNome, campoTelefone, campoDetalhes, campoEndereco, campoEnderecoComercial)
        campoNome.addKeyListener(salvar)
        campoTelefone.addKeyListener(salvar)
        campoEndereco.addKeyListener(salvar)
        campoEnderecoComercial.addKeyListener(salvar)
        campoDetalhes.addKeyListener(salvar)
        addWindowListener(Persistencia(contatos))

        // Configuration a janela
        pack()
        this.setSize(850, 650)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
    }

    init {
        montaJanela()
    }
}