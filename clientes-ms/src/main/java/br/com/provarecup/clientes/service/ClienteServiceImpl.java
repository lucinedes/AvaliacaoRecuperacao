package br.com.provarecup.clientes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.netflix.discovery.converters.Auto;

import br.com.provarecup.clientes.clienteHTTP.VeiculoFeignClient;
import br.com.provarecup.clientes.model.Cliente;
import br.com.provarecup.clientes.model.ClienteDto;
import br.com.provarecup.clientes.repository.ClienteRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository repo;

    @Autowired
    private VeiculoFeignClient veiculosMsClient;

    @Override
    public ClienteDto criarCliente(ClienteDto cliente) {
        return salvarCliente(cliente);
    }

    @Override
    public List<ClienteDto> obterTodos() {
        List<ClienteDto> clientes = repo.findAll();

        return clientes.stream()
            .map(cliente -> new ModelMapper().map(cliente, ClienteDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDto> obterPorId(String id) {
        Optional<ClienteDto> cliente = repo.findById(id);
 
         
        if(cliente.isPresent()) {
            ClienteDto dto = new ModelMapper().map(cliente.get(), ClienteDto.class);
            dto.setVeiculo(veiculosMsClient.obterVeiculo(id));
            return Optional.of(dto);
        }
 
        return Optional.empty();
     }

    @Override
    public void removerCliente(String id) {
        repo.deleteById(id);
    }

    @Override
    public ClienteDto atualizarCliente(String id, ClienteDto cliente) {
        cliente.setId(id);
        return salvarCliente(cliente);
    }

    private ClienteDto salvarCliente(ClienteDto cliente) {
        ModelMapper mapper = new ModelMapper();
        Cliente clienteEntidade = mapper.map(cliente, Cliente.class);
        clienteEntidade = repo.save(clienteEntidade);

        return mapper.map(clienteEntidade, ClienteDto.class);
    }

}
