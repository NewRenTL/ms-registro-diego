package com.codigo.msregistrodiego.domain.ports.in;

import com.codigo.msregistrodiego.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregistrodiego.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistrodiego.domain.aggregates.request.RequestEmpresa;
import com.codigo.msregistrodiego.domain.aggregates.request.RequestPersona;

import java.util.List;
import java.util.Optional;

public interface EmpresaServiceIn {
    EmpresaDTO crearEmpresaIn(RequestEmpresa requestEmpresa);

    Optional<EmpresaDTO> obtenerEmpresaIn(Long id);

    List<EmpresaDTO> obtenerTodosIn();

    EmpresaDTO actualizarIn(Long id, RequestEmpresa requestEmpresa);

    EmpresaDTO deleteIn(Long id);
}
