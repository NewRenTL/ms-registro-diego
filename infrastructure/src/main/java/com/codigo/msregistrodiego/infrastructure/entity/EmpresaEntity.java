package com.codigo.msregistrodiego.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "empresa")
@Getter
@Setter
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    public String numeroDocumento;



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

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_documento_id",nullable = false)
    public TipoDocumentoEntity tipoDocumento;
}
