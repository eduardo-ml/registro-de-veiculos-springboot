package com.eduardo_ml.registro_de_veiculos.service;

import com.eduardo_ml.registro_de_veiculos.dto.VeiculoRequestDTO;
import com.eduardo_ml.registro_de_veiculos.dto.VeiculoResponseDTO;
import com.eduardo_ml.registro_de_veiculos.exception.ResourceNotFound;
import com.eduardo_ml.registro_de_veiculos.model.Veiculo;
import com.eduardo_ml.registro_de_veiculos.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public VeiculoResponseDTO registrarVeiculo(VeiculoRequestDTO veiculoDTO) {
        Veiculo veiculo = paraEntidade(veiculoDTO);
        Veiculo veiculoSalvo = veiculoRepository.save(veiculo);
        return paraResponseDTO(veiculoSalvo);
    }

    public List<VeiculoResponseDTO> listarVeiculos() {
        return veiculoRepository.findAll()
                .stream()
                .map(this::paraResponseDTO)
                .collect(Collectors.toList());
    }

    public VeiculoResponseDTO buscarPorId(Long id) {
        Veiculo veiculo = encontrarVeiculoPorId(id);
        return paraResponseDTO(veiculo);
    }

    public VeiculoResponseDTO atualizarVeiculo(Long id, VeiculoRequestDTO veiculoDTO) {
        Veiculo veiculoExistente = encontrarVeiculoPorId(id);

        veiculoExistente.setPlaca(veiculoDTO.getPlaca());
        veiculoExistente.setMarca(veiculoDTO.getMarca());
        veiculoExistente.setModelo(veiculoDTO.getModelo());
        veiculoExistente.setAno(veiculoDTO.getAno());

        Veiculo veiculoAtualizado = veiculoRepository.save(veiculoExistente);
        return paraResponseDTO(veiculoAtualizado);
    }

    public void excluirVeiculo(Long id) {
        encontrarVeiculoPorId(id);
        veiculoRepository.deleteById(id);
    }

    private Veiculo encontrarVeiculoPorId(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Veiculo com id " + id + " não encontrado."));
    }

    private Veiculo paraEntidade(VeiculoRequestDTO dto) {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setMarca(dto.getMarca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setAno(dto.getAno());
        return veiculo;
    }

    private VeiculoResponseDTO paraResponseDTO(Veiculo veiculo) {
        VeiculoResponseDTO dto = new VeiculoResponseDTO();
        dto.setId(veiculo.getId());
        dto.setPlaca(veiculo.getPlaca());
        dto.setMarca(veiculo.getMarca());
        dto.setModelo(veiculo.getModelo());
        dto.setAno(veiculo.getAno());
        return dto;
    }
}