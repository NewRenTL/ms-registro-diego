package com.codigo.msregistrodiego.domain.aggregates.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestEmpresa {
    private String tipoDoc;
    private String numRuc;
}
