package br.com.iti.validadordesenha.validasenha

abstract class Response{
    abstract val isValid: Boolean
}

data class SenhaInvalidaResponse(
    override val isValid: Boolean,
    var mensagem: String
    ): Response()

data class SenhaValidaResponse(
    override val isValid: Boolean,
): Response()