package br.com.iti.validadordesenha.validasenha

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/valida-senha")
class ValidaSenhaController {

    @PostMapping
    fun valida(@Valid @RequestBody validaSenhaRequest: ValidaSenhaRequest): ResponseEntity<Boolean> {
        return ResponseEntity.ok(true)
    }
}