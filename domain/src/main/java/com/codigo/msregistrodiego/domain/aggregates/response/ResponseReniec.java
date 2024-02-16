package com.codigo.msregistrodiego.domain.aggregates.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseReniec {
    private String nombres;
    private String apellidoPaterno;

    private String apellidoMaterno;

    private String tipoDocumento;

    private String numeroDocumento;

    private String digitoVerificador;
}
