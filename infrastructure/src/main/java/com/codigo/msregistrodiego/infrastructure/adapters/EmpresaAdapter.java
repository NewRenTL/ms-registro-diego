package com.codigo.msregistrodiego.infrastructure.adapters;


import com.codigo.msregistrodiego.domain.aggregates.constants.Constants;
import com.codigo.msregistrodiego.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregistrodiego.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistrodiego.domain.aggregates.request.RequestEmpresa;
import com.codigo.msregistrodiego.domain.aggregates.request.RequestPersona;
import com.codigo.msregistrodiego.domain.aggregates.response.ResponseReniec;
import com.codigo.msregistrodiego.domain.aggregates.response.ResponseSunat;
import com.codigo.msregistrodiego.domain.ports.out.EmpresaServiceOut;
import com.codigo.msregistrodiego.domain.ports.out.PersonServiceOut;
import com.codigo.msregistrodiego.infrastructure.entity.EmpresaEntity;
import com.codigo.msregistrodiego.infrastructure.entity.PersonaEntity;
import com.codigo.msregistrodiego.infrastructure.entity.TipoDocumentoEntity;
import com.codigo.msregistrodiego.infrastructure.mapper.EmpresaMapper;
import com.codigo.msregistrodiego.infrastructure.repository.EmpresaRepository;
import com.codigo.msregistrodiego.infrastructure.repository.TipoDocumentoRepository;
import com.codigo.msregistrodiego.infrastructure.rest.client.ClientSunat;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaAdapter implements EmpresaServiceOut {
    private final EmpresaRepository empresaRepository;
    private TipoDocumentoRepository tipoDocumentoRepository;
    private final EmpresaMapper empresaMapper;

    private final ClientSunat clienteSunat;

    @Value("${token.api}")
    private String tokenApi;

    @Override
    public EmpresaDTO crearEmpresaOut(RequestEmpresa requestEmpresa) {
        ResponseSunat responseSunat = getExecutionSunat(requestEmpresa.getNumRuc());
        empresaRepository.save(getEntity(responseSunat,requestEmpresa));
        return empresaMapper.mapToDTO(getEntity(responseSunat,requestEmpresa));
    }

    @Override
    public Optional<EmpresaDTO> obtenerEmpresaOut(Long id) {
        return Optional.ofNullable(empresaMapper.mapToDTO(empresaRepository.findById(id).get()));
    }

    @Override
    public List<EmpresaDTO> obtenerTodosOut() {
        List<EmpresaDTO> empresaDTOList = new ArrayList<>();
        List<EmpresaEntity> entities = empresaRepository.findAll();
        for (EmpresaEntity empresaEntity:entities)
        {
            EmpresaDTO empresaDTO = empresaMapper.mapToDTO(empresaEntity);
            empresaDTOList.add(empresaDTO);
        }
        return empresaDTOList;
    }

    @Override
    public EmpresaDTO actualizarOut(Long id, RequestEmpresa requestEmpresa) {
        boolean exists = empresaRepository.existsById(id);
        if(exists)
        {
            Optional<EmpresaEntity> entity = empresaRepository.findById(id);
            ResponseSunat responseSunat = getExecutionSunat(requestEmpresa.getNumRuc());
            empresaRepository.save(getEntityUpdate(responseSunat,entity.get()));

            return empresaMapper.mapToDTO(getEntityUpdate(responseSunat,entity.get()));
        }
        return null;
    }

    @Override
    public EmpresaDTO deleteOut(Long id) {
        boolean exists = empresaRepository.existsById(id);
        if(exists)
        {
            Optional<EmpresaEntity> entity = empresaRepository.findById(id);
            entity.get().setEstado(0);
            entity.get().setUsuaDelet(Constants.AUDIT_ADMIN);
            entity.get().setDateDelet(getTimestamp());
            empresaRepository.save(entity.get());
            return empresaMapper.mapToDTO(entity.get());
        }
        return null;
    }

    private EmpresaEntity getEntity(ResponseSunat responseSunat, RequestEmpresa requestEmpresa)
    {
        TipoDocumentoEntity tipoDocumentoEntity = tipoDocumentoRepository.findByCodTipo(requestEmpresa.getTipoDoc());
        EmpresaEntity entity = new EmpresaEntity();
        entity.setTipoDocumento(tipoDocumentoEntity);
        entity.setNumeroDocumento(responseSunat.getNumeroDocumento());
        entity.setNombreComercial(responseSunat.getRazonSocial());
        entity.setRazonSocial(responseSunat.getRazonSocial());
        entity.setEstado(Constants.STATUS_ACTIVE);
        entity.setUsuaCrea(Constants.AUDIT_ADMIN);
        entity.setDateCreate(getTimestamp());
        return entity;
    }

    private EmpresaEntity getEntityUpdate(ResponseSunat responseSunat,EmpresaEntity empresaActualizar)
    {
        empresaActualizar.setRazonSocial(responseSunat.getRazonSocial());
        empresaActualizar.setNombreComercial(responseSunat.getRazonSocial());
        empresaActualizar.setUsuaModif(Constants.AUDIT_ADMIN);
        empresaActualizar.setDateModif(getTimestamp());
        return empresaActualizar;
    }

    private ResponseSunat getExecutionSunat(String numRuc) {
        String authorization = "Bearer "+tokenApi;
        ResponseSunat responseSunat = clienteSunat.getInfoSunat(numRuc,authorization);
        return responseSunat;
    }
    private Timestamp getTimestamp()
    {
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTime);
        return timestamp;
    }
}
