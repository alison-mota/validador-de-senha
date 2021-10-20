package br.com.iti.validadordesenha.validasenha

import br.com.iti.validadordesenha.compartilhado.constantes.RegexEMensagens
import org.springframework.stereotype.Service

@Service
class ValidaSenhaService {

    fun valida(senha: String): ValidaSenhaResponse {

        RegexEMensagens.listaDeValidadores.map {
            val validado = senha.matches(it.regex)
            if (!validado)
                return ValidaSenhaResponse(validado, it.mensagem)
        }
        return ValidaSenhaResponse(true)
    }
}

data class Dto(
    val regex: Regex,
    val mensagem: String
)