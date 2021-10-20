package br.com.iti.validadordesenha.validasenha

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ValidaSenhaServiceTest {

    private val validaSenhaService = ValidaSenhaService()

    @Test
    internal fun `deve retornar um objeto validasenharesponse com isvalid true quando a senha eh valida`() {

        val senha = "AbTp9!fok"
        val senhaValidada = validaSenhaService.valida(senha)
        assertTrue(senhaValidada.isValid)
    }

    @Test
    internal fun `deve retornar um objeto validasenharesponse com isvalid false e uma mensagem quando a senha nao conter caractere minusculo`() {

        val senha = "ABTP9!FOK"
        val mensagem = "É preciso ter uma letra minuscula"
        val senhaValidada = validaSenhaService.valida(senha)

        assertFalse(senhaValidada.isValid)
        assertTrue(senhaValidada.mensagem.equals(mensagem))
    }

    @Test
    internal fun `deve retornar um objeto validasenharesponse com isvalid false e uma mensagem quando a senha nao conter caractere maiusculo`() {

        val senha = "abtp9!fok"
        val mensagem = "É preciso ter uma letra maiuscula"
        val senhaValidada = validaSenhaService.valida(senha)

        assertFalse(senhaValidada.isValid)
        assertTrue(senhaValidada.mensagem.equals(mensagem))
    }

    @Test
    internal fun `deve retornar um objeto validasenharesponse com isvalid false e uma mensagem quando a senha nao conter numero`() {

        val senha = "AbTpF!fok"
        val mensagem = "É preciso ter um caractere numérico"
        val senhaValidada = validaSenhaService.valida(senha)

        assertFalse(senhaValidada.isValid)
        assertTrue(senhaValidada.mensagem.equals(mensagem))
    }

    @Test
    internal fun `deve retornar um objeto validasenharesponse com isvalid false e uma mensagem quando a senha nao conter um caractere especial`() {

        val senha = "AbTp9Ffok"
        val mensagem = "É preciso ter um caractere especial: !@#$%^&*()-+"
        val senhaValidada = validaSenhaService.valida(senha)

        assertFalse(senhaValidada.isValid)
        assertTrue(senhaValidada.mensagem.equals(mensagem))
    }

    @Test
    internal fun `deve retornar um objeto validasenharesponse com isvalid false e uma mensagem quando a senha tiver um espaco`() {

        val senha = "AbTp9 !fok"
        val mensagem = "É preciso remover o(s) espaço(s) em branco ou caracteres repetidos"
        val senhaValidada = validaSenhaService.valida(senha)

        assertFalse(senhaValidada.isValid)
        assertTrue(senhaValidada.mensagem.equals(mensagem))
    }

    @Test
    internal fun `deve retornar um objeto validasenharesponse com isvalid false e uma mensagem quando a senha tiver um caractere repetido`() {

        val senha = "AbTp9A!fok"
        val mensagem = "É preciso remover o(s) espaço(s) em branco ou caracteres repetidos"
        val senhaValidada = validaSenhaService.valida(senha)

        assertFalse(senhaValidada.isValid)
        assertTrue(senhaValidada.mensagem.equals(mensagem))
    }

    @Test
    internal fun `deve retornar um objeto validasenharesponse com isvalid false e uma mensagem quando a senha tiver menos que 9 caracteres`() {

        val senha = "AbTp9!fo"
        val mensagem = "A senha precisa ter no mínimo 9 caracteres"
        val senhaValidada = validaSenhaService.valida(senha)

        assertFalse(senhaValidada.isValid)
        assertTrue(senhaValidada.mensagem.equals(mensagem))
    }
}