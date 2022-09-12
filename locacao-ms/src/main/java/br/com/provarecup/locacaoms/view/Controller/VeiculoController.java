package br.com.provarecup.locacaoms.view.Controller;

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
import br.com.provarecup.locacaoms.Compatilhado.VeiculoDto;
import br.com.provarecup.locacaoms.service.VeiculoService;
import br.com.provarecup.locacaoms.view.model.VeiculoModeloAlteracao;
import br.com.provarecup.locacaoms.view.model.VeiculoModeloResponse;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }    

    @PostMapping
    public ResponseEntity<VeiculoModeloResponse> criarVeiculo(@RequestBody @Valid VeiculoModeloAlteracao Veiculo) {
        ModelMapper mapper = new ModelMapper();
        VeiculoDto dto = mapper.map(Veiculo, VeiculoDto.class);
        dto = service.criarVeiculo(dto);
        return new ResponseEntity<>(mapper.map(dto, VeiculoModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<VeiculoModeloResponse>> obterTodos() {
        List<VeiculoDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<VeiculoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, VeiculoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{marca}/lista")
    public ResponseEntity<List<VeiculoModeloResponse>> obterPorMarca(@PathVariable String marca) {
        List<VeiculoDto> dtos = service.obterPorMarca(marca);

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<VeiculoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, VeiculoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<VeiculoModeloResponse> obterPorId(@PathVariable String id) {
        Optional<VeiculoDto> Veiculo = service.obterPorId(id);

        if(Veiculo.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(Veiculo.get(), VeiculoModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<VeiculoModeloResponse> atualizarVeiculo(@PathVariable String id,
        @Valid @RequestBody VeiculoModeloAlteracao Veiculo) {
        ModelMapper mapper = new ModelMapper();
        VeiculoDto dto = mapper.map(Veiculo, VeiculoDto.class);
        dto = service.atualizarVeiculo(id, dto);

        return new ResponseEntity<>(mapper.map(dto, VeiculoModeloResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerVeiculo(@PathVariable String id) {
        service.removerVeiculo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
