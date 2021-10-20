package br.com.iti.validadordesenha.validasenha

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/valida-senha")
class ValidaSenhaController(val validaSenhaService: ValidaSenhaService) {


    @PostMapping
    fun valida(@Valid @RequestBody validaSenhaRequest: ValidaSenhaRequest): ResponseEntity<ValidaSenhaResponse> {
        val senhaValidada = validaSenhaService.valida(validaSenhaRequest.senha)
        //Retorna um json com isValid=false e a mensagem de erro conforme o problema.
        if (!senhaValidada.isValid) return ResponseEntity.badRequest().body(senhaValidada)

        //Retorna um json com isValid=true caso a senha passe pela validação (ver as regras no arquivo README)
        return ResponseEntity.ok(senhaValidada)
    }
}