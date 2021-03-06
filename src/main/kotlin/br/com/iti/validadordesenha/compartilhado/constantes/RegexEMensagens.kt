package br.com.iti.validadordesenha.compartilhado.constantes

import br.com.iti.validadordesenha.validasenha.Dto

class RegexEMensagens {

    companion object {

        private val espacoERepeticao = Regex("^(?:([A-Za-z\\d!@#$%^&*()-+])(?!.*\\1))*$")
        private val letraMinuscula = Regex("^(?=.*?[a-z])(?:([A-Za-z\\d!@#$%^&*()-+])(?!.*\\1))*$")
        private val letraMaiuscula = Regex("^(?=.*?[A-Z])(?:([A-Za-z\\d!@#$%^&*()-+])(?!.*\\1))*$")
        private val caractereNumerico = Regex("^(?=.*?[0-9])(?:([A-Za-z\\d!@#$%^&*()-+])(?!.*\\1))*$")
        private val caractereEspecial = Regex("^(?=.*?[!@#$%^&*()+-])(?:([A-Za-z\\d!@#$%^&*()-+])(?!.*\\1))*$")
        private val noveCaracteres = Regex(".{9,}")

        val listaDeValidadores: List<Dto> = arrayListOf(
            Dto(espacoERepeticao, "É preciso remover o(s) espaço(s) em branco ou caracteres repetidos"),
            Dto(letraMinuscula, "É preciso ter uma letra minuscula"),
            Dto(letraMaiuscula, "É preciso ter uma letra maiuscula"),
            Dto(caractereNumerico, "É preciso ter um caractere numérico"),
            Dto(caractereEspecial, "É preciso ter um caractere especial: !@#$%^&*()-+"),
            Dto(noveCaracteres, "A senha precisa ter no mínimo 9 caracteres"),
        )
    }
}