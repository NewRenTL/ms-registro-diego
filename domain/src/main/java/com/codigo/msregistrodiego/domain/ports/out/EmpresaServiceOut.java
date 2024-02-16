package com.codigo.msregistrodiego.domain.ports.out;

import com.codigo.msregistrodiego.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregistrodiego.domain.aggregates.request.RequestEmpresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaServiceOut {
    EmpresaDTO crearEmpresaOut(RequestEmpresa requestEmpresa);

    Optional<EmpresaDTO> obtenerEmpresaOut(Long id);

    List<EmpresaDTO> obtenerTodosOut();

    EmpresaDTO actualizarOut(Long id, RequestEmpresa requestEmpresa);

    EmpresaDTO deleteOut(Long id);
}
