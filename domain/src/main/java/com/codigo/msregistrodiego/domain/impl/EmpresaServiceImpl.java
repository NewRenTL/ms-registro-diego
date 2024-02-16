package com.codigo.msregistrodiego.domain.impl;

import com.codigo.msregistrodiego.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregistrodiego.domain.aggregates.request.RequestEmpresa;
import com.codigo.msregistrodiego.domain.ports.in.EmpresaServiceIn;
import com.codigo.msregistrodiego.domain.ports.out.EmpresaServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaServiceIn {

    private final EmpresaServiceOut empresaServiceOut;
    @Override
    public EmpresaDTO crearEmpresaIn(RequestEmpresa requestEmpresa) {

        return empresaServiceOut.crearEmpresaOut(requestEmpresa);
    }

    @Override
    public Optional<EmpresaDTO> obtenerEmpresaIn(Long id) {
        return empresaServiceOut.obtenerEmpresaOut(id);
    }

    @Override
    public List<EmpresaDTO> obtenerTodosIn() {
        return empresaServiceOut.obtenerTodosOut();
    }

    @Override
    public EmpresaDTO actualizarIn(Long id, RequestEmpresa requestEmpresa) {
        return empresaServiceOut.actualizarOut(id,requestEmpresa);
    }

    @Override
    public EmpresaDTO deleteIn(Long id) {
        return null;
    }
}
