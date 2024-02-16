package com.codigo.msregistrodiego.domain.ports.out;

import com.codigo.msregistrodiego.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistrodiego.domain.aggregates.request.RequestPersona;

import java.util.List;
import java.util.Optional;

public interface PersonServiceOut {
    PersonaDTO crearPersonOut(RequestPersona requestPersona);

    Optional<PersonaDTO> obtenerPersonaOut(Long id);

    List<PersonaDTO> obtenerTodosOut();

    PersonaDTO actualizarOut(Long id, RequestPersona requestPersona);

    PersonaDTO deleteOut(Long id);
}
