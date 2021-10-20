package br.com.iti.validadordesenha.validasenha

import br.com.iti.validadordesenha.compartilhado.constantes.RegexEMensagens
import org.springframework.stereotype.Service

/*
  Ler o arquivo README para consultar as regras de senha válida
 */

@Service
class ValidaSenhaService {

    fun valida(senha: String): ValidaSenhaResponse {

        //Usa uma lista de regras em formato Regex que foi instanciada na classe RegexEMensagens para validar a String
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