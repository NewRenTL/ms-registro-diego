package com.codigo.msregistrodiego.infrastructure.mapper;

import com.codigo.msregistrodiego.domain.aggregates.dto.EmpresaDTO;
import com.codigo.msregistrodiego.infrastructure.entity.EmpresaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmpresaMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public EmpresaDTO mapToDTO(EmpresaEntity entity)
    {
        return modelMapper.map(entity,EmpresaDTO.class);
    }

    public EmpresaEntity mapToEntity(EmpresaDTO empresaDTO){
        return modelMapper.map(empresaDTO,EmpresaEntity.class);
    }
}
