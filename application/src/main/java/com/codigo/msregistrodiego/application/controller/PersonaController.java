package com.codigo.msregistrodiego.application.controller;

import com.codigo.msregistrodiego.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistrodiego.domain.aggregates.request.RequestPersona;
import com.codigo.msregistrodiego.domain.ports.in.PersonServiceIn;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/persona")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonServiceIn personServiceIn;


    @PostMapping
    public ResponseEntity<PersonaDTO> registrar(@RequestBody RequestPersona requestPersona)
    {
        return ResponseEntity.
                status(HttpStatus.CREATED).
                    body(personServiceIn.
                        crearPersonaIn(requestPersona));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> obtenerPersona(@PathVariable Long id)
    {
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(personServiceIn.obtenerPersonaIn(id).get());
    }

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> obtenerTodos()
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personServiceIn.obtenerTodosIn());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> actualizar(@PathVariable Long id,@RequestBody RequestPersona requestPersona)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personServiceIn.actualizarIn(id,requestPersona));
    }
}
