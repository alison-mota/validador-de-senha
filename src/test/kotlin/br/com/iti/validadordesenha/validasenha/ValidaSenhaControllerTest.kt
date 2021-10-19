package br.com.iti.validadordesenha.validasenha

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
internal class ValidaSenhaControllerTest(@Autowired val mockMvc: MockMvc) {

    private val url = "/api/v1/valida-senha"

    @Test
    internal fun `deve retornar status Ok com corpo true quando a senha eh valida`() {
        val senha: ValidaSenhaRequest = ValidaSenhaRequest("AbTp9!fok")

        mockMvc.perform(
            post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    ObjectMapper()
                        .writeValueAsString(senha)
                )
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("isValid").isBoolean)
            .andExpect(jsonPath("isValid").value(true))
    }

    @Test
    internal fun `deve retornar 400 quando a senha for em branco`() {
        val senha: ValidaSenhaRequest = ValidaSenhaRequest("")

        mockMvc.perform(
            post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    ObjectMapper()
                        .writeValueAsString(senha)
                )
        )
            .andExpect(status().isBadRequest)
    }

    @Test
    internal fun `deve retornar 400 e um boolean false quando a senha tiver caractere repetido`() {
        val senha: ValidaSenhaRequest = ValidaSenhaRequest("AbTpp9!fok")

        mockMvc.perform(
            post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    ObjectMapper()
                        .writeValueAsString(senha)
                )
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("isValid").isBoolean)
            .andExpect(jsonPath("isValid").value(false))
    }

    @Test
    internal fun `deve retornar 400 e um boolean false quando a senha for menor que 9 digitos`() {
        val senha: ValidaSenhaRequest = ValidaSenhaRequest("AbTp9!fo")

        mockMvc.perform(
            post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    ObjectMapper()
                        .writeValueAsString(senha)
                )
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("isValid").isBoolean)
            .andExpect(jsonPath("isValid").value(false))
    }

    @Test
    internal fun `deve retornar 400 e um boolean false quando a senha nao tiver caractere especial`() {
        val senha: ValidaSenhaRequest = ValidaSenhaRequest("AbTpa92fo")

        mockMvc.perform(
            post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    ObjectMapper()
                        .writeValueAsString(senha)
                )
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("isValid").isBoolean)
            .andExpect(jsonPath("isValid").value(false))
    }

    @Test
    internal fun `deve retornar 400 e um boolean false quando a senha nao tiver um numero`() {
        val senha: ValidaSenhaRequest = ValidaSenhaRequest("AbTpaLlfo")

        mockMvc.perform(
            post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    ObjectMapper()
                        .writeValueAsString(senha)
                )
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("isValid").isBoolean)
            .andExpect(jsonPath("isValid").value(false))
    }

    @Test
    internal fun `deve retornar 400 e um boolean false quando a senha nao tiver letra maiuscula`() {
        val senha: ValidaSenhaRequest = ValidaSenhaRequest("abtpj92f!")

        mockMvc.perform(
            post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    ObjectMapper()
                        .writeValueAsString(senha)
                )
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("isValid").isBoolean)
            .andExpect(jsonPath("isValid").value(false))
    }

    @Test
    internal fun `deve retornar 400 e um boolean false quando a senha nao tiver letra minuscula`() {
        val senha: ValidaSenhaRequest = ValidaSenhaRequest("ABTPJ92F!")

        mockMvc.perform(
            post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    ObjectMapper()
                        .writeValueAsString(senha)
                )
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("isValid").isBoolean)
            .andExpect(jsonPath("isValid").value(false))
    }

    @Test
    internal fun `deve retornar 400 e um boolean false quando a senha tiver 1 espaco em branco`() {
        val senha: ValidaSenhaRequest = ValidaSenhaRequest("AbTp9 !fok!")

        mockMvc.perform(
            post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    ObjectMapper()
                        .writeValueAsString(senha)
                )
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("isValid").isBoolean)
            .andExpect(jsonPath("isValid").value(false))
    }
}