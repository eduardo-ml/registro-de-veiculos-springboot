package com.eduardo_ml.registro_de_veiculos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoResponseDTO {
    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
}
