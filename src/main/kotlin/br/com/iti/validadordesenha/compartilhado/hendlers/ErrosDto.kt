package br.com.iti.validadordesenha.compartilhado.hendlers

data class ErrosDto(
    val field: String?,
    val message: String?,
    val isValid: Boolean = false
)