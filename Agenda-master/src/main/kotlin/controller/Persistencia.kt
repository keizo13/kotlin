package controller

import model.Contato
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.io.*
import java.util.logging.Level
import java.util.logging.Logger
import javax.swing.DefaultListModel

class Persistencia(private val contatos: DefaultListModel<Contato>) : WindowAdapter() {
    override fun windowOpened(e: WindowEvent) {
        try {
            FileInputStream(NOME_ARQUIVO).let { arquivo ->
                ObjectInputStream(arquivo).let { objectInputStream ->
                    for (objeto in objectInputStream.readObject() as Array<Contato?>) {
                        contatos.addElement(objeto)
                    }
                }
            }
        } catch (ex: IOException) {
            Logger.getLogger(Persistencia::class.java.name).log(Level.SEVERE, null, ex)
        } catch (ex: ClassNotFoundException) {
            Logger.getLogger(Persistencia::class.java.name).log(Level.SEVERE, null, ex)
        }
    }

    override fun windowClosing(e: WindowEvent) {
        try {
            FileOutputStream(NOME_ARQUIVO).let { arquivo ->
                ObjectOutputStream(arquivo).let { objectOutputStream ->
                    objectOutputStream.writeObject(
                        contatos.toArray()
                    )
                }
            }
        } catch (ex: IOException) {
            Logger.getLogger(Persistencia::class.java.name).log(Level.SEVERE, null, ex)
        }
    }

    companion object {
        private const val NOME_ARQUIVO = "agenda.dat"
    }
}