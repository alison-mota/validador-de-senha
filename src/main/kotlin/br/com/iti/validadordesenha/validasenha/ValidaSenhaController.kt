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
    fun valida(@Valid @RequestBody validaSenhaRequest: ValidaSenhaRequest): ResponseEntity<Response> {
        val senhaValidada = validaSenhaService.valida(validaSenhaRequest.senha)
        if (!senhaValidada.isValid) return ResponseEntity.badRequest().body(senhaValidada)

        return ResponseEntity.ok(senhaValidada)
    }
}