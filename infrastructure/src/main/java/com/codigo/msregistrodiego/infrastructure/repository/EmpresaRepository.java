package com.codigo.msregistrodiego.infrastructure.repository;

import com.codigo.msregistrodiego.infrastructure.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity,Long> {

}
