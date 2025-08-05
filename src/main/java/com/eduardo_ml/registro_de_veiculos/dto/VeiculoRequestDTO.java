package com.eduardo_ml.registro_de_veiculos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoRequestDTO {
    @NotBlank
    private String placa;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotNull
    private int ano;
}
