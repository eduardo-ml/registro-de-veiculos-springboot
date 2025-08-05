package com.eduardo_ml.registro_de_veiculos.repository;

import com.eduardo_ml.registro_de_veiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
