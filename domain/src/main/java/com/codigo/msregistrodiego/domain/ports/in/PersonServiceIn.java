package com.codigo.msregistrodiego.domain.ports.in;

import com.codigo.msregistrodiego.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistrodiego.domain.aggregates.request.RequestPersona;
import feign.Request;

import java.util.List;
import java.util.Optional;

public interface PersonServiceIn {
    PersonaDTO crearPersonaIn(RequestPersona requestPersona);

    Optional<PersonaDTO> obtenerPersonaIn(Long id);

    List<PersonaDTO> obtenerTodosIn();

    PersonaDTO actualizarIn(Long id, RequestPersona requestPersona);

    PersonaDTO deleteIn(Long id);
}
