package br.com.iti.validadordesenha.validasenha

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL

@JsonInclude(NON_NULL)
data class ValidaSenhaResponse(
    val isValid: Boolean
    ) {

    var mensagem: String? = null

    constructor(isValid: Boolean, mensagem: String): this(isValid){
        this.mensagem = mensagem
    }
}