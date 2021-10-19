package br.com.iti.validadordesenha.validasenha

data class ValidaSenhaResponse(
    val isValid: Boolean,

){
    var mensagem: String? = null

    constructor(isValid: Boolean, mensagem: String): this(isValid){
        this.mensagem = mensagem
    }
}