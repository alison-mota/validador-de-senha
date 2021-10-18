package br.com.iti.validadordesenha.validasenha

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/valida-senha")
class ValidaSenhaController {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping
    fun valida(@Valid @RequestBody validaSenhaRequest: ValidaSenhaRequest): ResponseEntity<Boolean> {

        logger.error("[ValidaSenhaController]")
        return ResponseEntity.ok(true)
    }
}