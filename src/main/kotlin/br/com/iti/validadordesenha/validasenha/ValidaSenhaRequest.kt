package br.com.iti.validadordesenha.validasenha

import br.com.iti.validadordesenha.compartilhado.constantes.ValidaSenha.Companion.VALIDA_SENHA_MESSAGE
import br.com.iti.validadordesenha.compartilhado.constantes.ValidaSenha.Companion.VALIDA_SENHA_REGEX
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

class ValidaSenhaRequest(
    @field:Pattern(regexp = VALIDA_SENHA_REGEX, message = VALIDA_SENHA_MESSAGE)
    @field:NotBlank val senha: String
)