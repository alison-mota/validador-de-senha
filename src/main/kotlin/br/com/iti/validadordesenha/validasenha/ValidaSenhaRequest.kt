package br.com.iti.validadordesenha.validasenha

import javax.validation.constraints.NotBlank

class ValidaSenhaRequest(
    @field:NotBlank val senha: String
)