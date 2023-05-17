package br.com.alura.orgs

import br.com.alura.orgs.model.Usuario
import org.junit.Assert
import org.junit.Test

class TestaUsuario {

    @Test
    fun aoInserirEmailESenhaOUsuarioDeveSerValido(){
        val usuarioValido = Usuario(
            id = "01",
            email = "jenny@email.com",
            senha = "123456789"
        )

        val usuarioEhValido = usuarioValido.ehValido()

        Assert.assertEquals(true, usuarioEhValido)
    }
}