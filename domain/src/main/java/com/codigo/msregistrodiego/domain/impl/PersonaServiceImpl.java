package com.codigo.msregistrodiego.domain.impl;

import com.codigo.msregistrodiego.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistrodiego.domain.aggregates.request.RequestPersona;
import com.codigo.msregistrodiego.domain.ports.in.PersonServiceIn;
import com.codigo.msregistrodiego.domain.ports.out.PersonServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonServiceIn {

    private final PersonServiceOut personServiceOut;
    @Override
    public PersonaDTO crearPersonaIn(RequestPersona requestPersona) {
        return personServiceOut.crearPersonOut(requestPersona);
    }

    @Override
    public Optional<PersonaDTO> obtenerPersonaIn(Long id) {
        return personServiceOut.obtenerPersonaOut(id);
    }

    @Override
    public List<PersonaDTO> obtenerTodosIn() {
        return personServiceOut.obtenerTodosOut();
    }

    @Override
    public PersonaDTO actualizarIn(Long id, RequestPersona requestPersona) {
        return personServiceOut.actualizarOut(id,requestPersona);
    }

    @Override
    public PersonaDTO deleteIn(Long id) {
        return personServiceOut.deleteOut(id);
    }
}
