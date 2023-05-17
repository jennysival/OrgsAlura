package br.com.alura.orgs

import br.com.alura.orgs.model.Usuario
import org.junit.Assert
import org.junit.Test

class TestaUsuario {

    @Test
    fun aoInserirEmailESenhaOUsuarioDeveSerValido(){
        //arrange
        val usuario = Usuario(
            id = "01",
            email = "jenny@email.com",
            senha = "123456789"
        )

        //act
        val usuarioEhValido = usuario.ehValido()

        //assert
        Assert.assertEquals(true, usuarioEhValido)
    }

    @Test
    fun aoInserirEmailSemArrobaOUsuarioDeveSerInvalido(){
        //arrange
        val usuario = Usuario(
            id = "02",
            email = "jenny.com",
            senha = "123456789"
        )

        //act
        val usuarioEhInvalido = usuario.ehValido()

        //assert
        Assert.assertEquals(false, usuarioEhInvalido)
    }

    @Test
    fun aoInserirSenhaMenorQueSeisOUsuarioDeveSerInvalido(){
        //arrange
        val usuario = Usuario(
            id = "03",
            email = "jenny@email.com",
            senha = "1234"
        )

        //act
        val usuarioEhInvalido = usuario.ehValido()

        //assert
        Assert.assertEquals(false, usuarioEhInvalido)
    }
}