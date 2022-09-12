package br.com.provarecup.locacaoms.service;

import java.util.List;
import java.util.Optional;

import br.com.provarecup.locacaoms.Compatilhado.VeiculoDto;

public interface VeiculoService {
    
    VeiculoDto criarVeiculo(VeiculoDto veiculo);
    List<VeiculoDto> obterTodos();
    Optional<VeiculoDto> obterPorId(String id);
    List<VeiculoDto> obterPorMarca(String marca);
    void removerVeiculo(String id);
    VeiculoDto atualizarVeiculo(String id, VeiculoDto veiculo);
    
}
