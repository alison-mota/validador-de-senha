package br.com.iti.validadordesenha.compartilhado.handlers

data class ErrosDto(
    val field: String?,
    val message: String?,
    val isValid: Boolean = false
)