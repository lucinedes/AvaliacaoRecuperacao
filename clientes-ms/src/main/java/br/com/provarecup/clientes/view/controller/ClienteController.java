package br.com.provarecup.clientes.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.provarecup.clientes.model.Cliente;
import br.com.provarecup.clientes.model.ClienteDto;
import br.com.provarecup.clientes.service.ClienteService;
import br.com.provarecup.clientes.view.model.ClienteModeloRequest;
import br.com.provarecup.clientes.view.model.ClienteModeloResponse;
import br.com.provarecup.clientes.view.model.ClienteModeloResponseDetalhes;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }
    

    @PostMapping
    public ResponseEntity<ClienteModeloResponse> criarCliente(@RequestBody @Valid ClienteModeloRequest cliente) {
        ModelMapper mapper = new ModelMapper();
        ClienteDto dto = mapper.map(cliente, ClienteDto.class);
        dto = service.criarCliente(dto);
        return new ResponseEntity<>(mapper.map(dto, ClienteModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<ClienteModeloResponse>> obterTodos() {
        List<ClienteDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<ClienteModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, ClienteModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<ClienteModeloResponseDetalhes> obterPorId(@PathVariable String id) {
        Optional<ClienteDto> cliente = service.obterPorId(id);

        if(cliente.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(cliente.get(), clienteModeloResponseDetalhes.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ClienteModeloResponse> atualizarCliente(@PathVariable String id,
        @Valid @RequestBody Cliente cliente) {
        ModelMapper mapper = new ModelMapper();
        ClienteDto dto = mapper.map(cliente, ClienteDto.class);
        dto = service.atualizarCliente(id, dto);

        return new ResponseEntity<>(mapper.map(dto, ClienteModeloResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerCliente(@PathVariable String id) {
        service.removerCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
}
