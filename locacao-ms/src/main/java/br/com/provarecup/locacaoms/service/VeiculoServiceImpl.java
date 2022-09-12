package br.com.provarecup.locacaoms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.provarecup.locacaoms.Compatilhado.VeiculoDto;
import br.com.provarecup.locacaoms.model.Veiculo;
import br.com.provarecup.locacaoms.repository.VeiculoRepositorio;

public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepositorio repo;

    @Override
    public VeiculoDto criarVeiculo(VeiculoDto veiculo) {
        return salvarVeiculo(veiculo);
    }

    @Override
    public List<VeiculoDto> obterTodos() {
        List<Veiculo> veiculos = repo.findAll();

        return veiculos.stream()
            .map(veiculo -> new ModelMapper().map(veiculo, VeiculoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<VeiculoDto> obterPorId(String id) {
        Optional<Veiculo> veiculo = repo.findById(id);

       if(veiculo.isPresent()) {
           return Optional.of(new ModelMapper().map(veiculo.get(), VeiculoDto.class));
       }

       return Optional.empty();
    }

    @Override
    public List<VeiculoDto> obterPorMarca(String marca) {
        List<Veiculo> veiculos = repo.findByMarca(marca);

        return veiculos.stream()
            .map(veiculo -> new ModelMapper().map(veiculo, VeiculoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public void removerVeiculo(String id) {
        repo.deleteById(id);
    }

    @Override
    public VeiculoDto atualizarVeiculo(String id, VeiculoDto veiculo) {
        veiculo.setId(id);
        return salvarVeiculo(veiculo);
    }

    private VeiculoDto salvarVeiculo(VeiculoDto veiculo) {
        ModelMapper mapper = new ModelMapper();
        Veiculo veiculoEntidade = mapper.map(veiculo, Veiculo.class);
        veiculoEntidade = repo.save(veiculoEntidade);

        return mapper.map(veiculoEntidade, VeiculoDto.class);
    }
    
}
