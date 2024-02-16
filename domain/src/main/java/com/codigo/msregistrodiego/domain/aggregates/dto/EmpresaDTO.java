package com.codigo.msregistrodiego.domain.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpresaDTO {

    private Long idEmpresa;

    private String numDocu;

    private String razonSocial;

    private String nombreComercial;

    private Integer estado;

    private String usuaCrea;

    private Timestamp dateCreate;

    private String usuaModif;

    private Timestamp dateModif;

    private String usuaDelete;

    private Timestamp dateDelet;



    /*
    public String numeroDocumento;
    public String tipoDocumento;
    public String razonSocial;
    public String estado;
    public String condicion;
    public String direccion;
    public String ubigeo;
    public String viaTipo;
    public String viaNombre;
    public String zonaCodigo;
    public String zonaTipo;
    public String numero;
    public String interior;
    public String lote;
    public String dpto;
    public String manzana;
    public String kilometro;
    public String distrito;
    public String provincia;
    public String departamento;
    @JsonProperty("EsAgenteRetencion")
    public boolean esAgenteRetencion;
     */
}
