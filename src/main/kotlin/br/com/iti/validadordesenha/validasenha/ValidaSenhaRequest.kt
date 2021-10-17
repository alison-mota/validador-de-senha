package br.com.iti.validadordesenha.validasenha

import br.com.iti.validadordesenha.constantes.ValidaSenhaRegex.Companion.VALIDA_SENHA_REGEX
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

class ValidaSenhaRequest(
    @field:Pattern(regexp = VALIDA_SENHA_REGEX, message = "false")
    @field:NotBlank val senha: String
)