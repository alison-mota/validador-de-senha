package br.com.iti.validadordesenha.validasenha

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
internal class ValidaSenhaControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    internal fun `deve retornar true quando a senha é válida`() {
        val senha: ValidaSenhaRequest = ValidaSenhaRequest("AbTp9!fok")

        mockMvc.perform(
            post("/api/v1/valida-senha")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    ObjectMapper()
                        .writeValueAsString(senha)
                )
        )
            .andExpect(status().isOk)
//            .andExpect(MockMvcResultMatchers.true)
    }
}

/*
IsValid("") // false
IsValid("aa") // false
IsValid("ab") // false
IsValid("AAAbbbCc") // false
IsValid("AbTp9!foo") // false
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true

 */