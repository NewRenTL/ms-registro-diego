package com.codigo.msregistrodiego.infrastructure.repository;

import com.codigo.msregistrodiego.infrastructure.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity,Long> {
}
