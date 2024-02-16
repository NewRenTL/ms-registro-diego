package com.codigo.msregistrodiego.application.controller;


import com.codigo.msregistrodiego.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregistrodiego.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistrodiego.domain.aggregates.request.RequestEmpresa;
import com.codigo.msregistrodiego.domain.ports.in.EmpresaServiceIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/empresa")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaServiceIn empresaServiceIn;

    @PostMapping
    public ResponseEntity<EmpresaDTO> registrar(@RequestBody RequestEmpresa requestEmpresa)
    {
        return ResponseEntity.
                status(HttpStatus.CREATED).
                    body(empresaServiceIn.crearEmpresaIn(requestEmpresa));
    }

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> obtenerTodos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.obtenerTodosIn());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> actualizar(@PathVariable Long id,@RequestBody RequestEmpresa requestEmpresa)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.actualizarIn(id,requestEmpresa));
    }
}
