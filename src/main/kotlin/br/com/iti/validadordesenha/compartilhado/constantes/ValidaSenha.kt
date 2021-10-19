package br.com.iti.validadordesenha.compartilhado.constantes

class ValidaSenha {

    companion object {
        const val VALIDA_SENHA_REGEX: String =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[!@#$%^&*()-+])(?:([A-Za-z\\d!@#$%^&*()-+\\S])(?!.*\\1)){9,}$"
        const val VALIDA_SENHA_MESSAGE: String =
            "Senha fora do padrão esperado."
    }
}