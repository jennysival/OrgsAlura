package br.com.alura.orgs

import br.com.alura.orgs.model.Usuario
import org.junit.Assert.*
import org.junit.Test

class TestaUsuario {

    @Test
    fun `deve retornar true quando o usuario for valido`(){
        //arrange
        val usuario = Usuario(
            id = "01",
            email = "jenny@email.com",
            senha = "123456789"
        )

        //act
        val usuarioEhValido = usuario.ehValido()

        //assert
        assertTrue(usuarioEhValido)
    }

    @Test
    fun `deve retornar false quando o email for invalido`(){
        //arrange
        val usuario = Usuario(
            id = "02",
            email = "jenny.com",
            senha = "123456789"
        )

        //act
        val usuarioEhInvalido = usuario.ehValido()

        //assert
        assertFalse(usuarioEhInvalido)
    }

    @Test
    fun `deve retornar false quando a senha tiver menos que 6 caracteres`(){
        //arrange
        val usuario = Usuario(
            id = "03",
            email = "jenny@email.com",
            senha = "1234"
        )

        //act
        val usuarioEhInvalido = usuario.ehValido()

        //assert
        assertFalse(usuarioEhInvalido)
    }
}