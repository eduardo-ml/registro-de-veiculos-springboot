package com.eduardo_ml.registro_de_veiculos.controllers;

import com.eduardo_ml.registro_de_veiculos.dto.VeiculoRequestDTO;
import com.eduardo_ml.registro_de_veiculos.dto.VeiculoResponseDTO; // Nome corrigido
import com.eduardo_ml.registro_de_veiculos.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> registrarVeiculo(@Valid @RequestBody VeiculoRequestDTO veiculoDTO) {
        VeiculoResponseDTO novoVeiculo = veiculoService.registrarVeiculo(veiculoDTO);
        return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> listarVeiculos() {
        return ResponseEntity.ok(veiculoService.listarVeiculos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(veiculoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> atualizarVeiculo(@PathVariable Long id, @Valid @RequestBody VeiculoRequestDTO veiculoDTO) {
        VeiculoResponseDTO veiculoAtualizado = veiculoService.atualizarVeiculo(id, veiculoDTO);
        return ResponseEntity.ok(veiculoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVeiculo(@PathVariable Long id) {
        veiculoService.excluirVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}