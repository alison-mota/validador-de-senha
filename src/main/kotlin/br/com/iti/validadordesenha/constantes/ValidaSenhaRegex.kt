package br.com.iti.validadordesenha.constantes

class ValidaSenhaRegex {

    companion object {
        const val VALIDA_SENHA_REGEX: String =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[!@#$%^&*()-+])(?:([A-Za-z\\d!@#$%^&*()-+\\S])(?!.*\\1)){9,}$"
    }
}