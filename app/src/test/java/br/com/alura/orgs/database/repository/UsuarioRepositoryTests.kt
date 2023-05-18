package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.UsuarioDao
import br.com.alura.orgs.model.Usuario
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runTest

import org.junit.Test

class UsuarioRepositoryTests {

    @Test
    fun `deve chamar o dao quando salva um usuario`() = runTest {//runTest quando tem coroutine envolvida no teste, precisa adicionar dependencia pra funcionar
        //arrange
        val dao = mockk<UsuarioDao>()
        val usuarioRepository = UsuarioRepository(dao)
        val usuario = Usuario(id = "01", email = "jenny@email.com", senha = "123456789")

        coEvery { //every sem coroutine | coEvery com coroutine
            dao.salva(usuario)
        }.returns(mockk())

        //act
        usuarioRepository.salva(usuario)

        //assert
        coVerify { //verify sem coroutine | coVerify com coroutine
            dao.salva(usuario)
        }

    }

    @Test
    fun `deve chamar o dao quando autentica o usuario`() = runTest {//runTest quando tem coroutine envolvida no teste, precisa adicionar dependencia pra funcionar
        //arrange
        val dao = mockk<UsuarioDao>()
        val usuarioRepository = UsuarioRepository(dao)
        val usuario = Usuario(id = "01", email = "jenny@email.com", senha = "123456789")

        coEvery {//every sem coroutine | coEvery com coroutine
            dao.autentica(usuarioId = usuario.id, senha = usuario.senha)
        }.returns(usuario)

        //act
        usuarioRepository.autentica(usuarioId = usuario.id, senha = usuario.senha)

        //assert
        coVerify {//verify sem coroutine | coVerify com coroutine
            dao.autentica(usuarioId = usuario.id, senha = usuario.senha)
        }
    }
}