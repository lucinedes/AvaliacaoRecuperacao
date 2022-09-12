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

import br.com.provarecup.locacaoms.Compatilhado.LocacaoDto;
import br.com.provarecup.locacaoms.service.LocacaoService;
import br.com.provarecup.locacaoms.view.model.LocacaoModeloAlteracao;
import br.com.provarecup.locacaoms.view.model.LocacaoModeloResponse;

@RestController
@RequestMapping("/api/locacoes")
public class LocacaoController {
    @Autowired
    private LocacaoService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }    

    @PostMapping
    public ResponseEntity<LocacaoModeloResponse> criarLocacao(@RequestBody @Valid LocacaoModeloAlteracao Locacao) {
        ModelMapper mapper = new ModelMapper();
        LocacaoDto dto = mapper.map(Locacao, LocacaoDto.class);
        dto = service.criarLocacao(dto);
        return new ResponseEntity<>(mapper.map(dto, LocacaoModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<LocacaoModeloResponse>> obterTodos() {
        List<LocacaoDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<LocacaoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, LocacaoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{idLocacao}/lista")
    public ResponseEntity<List<LocacaoModeloResponse>> obterPorIdLocacao(@PathVariable String idLocacao) {
        Optional<LocacaoDto> dtos = service.obterPorId(idLocacao);

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<LocacaoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, LocacaoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<LocacaoModeloResponse> obterPorId(@PathVariable String id) {
        Optional<LocacaoDto> Locacao = service.obterPorId(id);

        if(Locacao.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(Locacao.get(), LocacaoModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<LocacaoModeloResponse> atualizarLocacao(@PathVariable String id,
        @Valid @RequestBody LocacaoModeloAlteracao Locacao) {
        ModelMapper mapper = new ModelMapper();
        LocacaoDto dto = mapper.map(Locacao, LocacaoDto.class);
        dto = service.atualizarLocacao(id, dto);

        return new ResponseEntity<>(mapper.map(dto, LocacaoModeloResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerLocacao(@PathVariable String id) {
        service.removerLocacao(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
