package com.codigo.msregistrodiego.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
public class tipoDocumentoDTO {
    private Long idTipoDocumento;

    private String codTipo;

    private String descTipo;

    private Integer estado;

    private String usuaCrea;

    private Timestamp dateCreate;

    private String usuaModif;

    private Timestamp dateModif;

    private String usuaDelete;

    private Timestamp dateDelet;
}
