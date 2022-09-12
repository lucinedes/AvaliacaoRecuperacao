package br.com.provarecup.locacaoms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.provarecup.locacaoms.Compatilhado.LocacaoDto;
import br.com.provarecup.locacaoms.model.Locacao;
import br.com.provarecup.locacaoms.repository.LocacaoRepositorio;

public class LocacaoServiceImpl implements LocacaoService{
    
    @Autowired
    private LocacaoRepositorio repo;

    @Override
    public LocacaoDto criarLocacao(LocacaoDto locacao){
        return salvarLocacao(locacao);
    }

    @Override
    public List<LocacaoDto> obterTodos() {
        List<Locacao> locacoes = repo.findAll();

        return locacoes.stream()
            .map(locacao -> new ModelMapper().map(locacao, LocacaoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<LocacaoDto> obterPorId(String id) {
        Optional<Locacao> locacao = repo.findById(id);

       if(locacao.isPresent()) {
           return Optional.of(new ModelMapper().map(locacao.get(), LocacaoDto.class));
       }

       return Optional.empty();
    }

    @Override
    public List<LocacaoDto> obterPorLocacao(String idLocacao) {
        List<Locacao> locacoes = repo.findByIdList(idLocacao);

        return locacoes.stream()
            .map(locacao -> new ModelMapper().map(locacao, LocacaoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public void removerLocacao(String id) {
        repo.deleteById(id);
    }

    @Override
    public LocacaoDto atualizarLocacao(String id, LocacaoDto locacao) {
        locacao.setId(id);
        return salvarLocacao(locacao);
    }
    private LocacaoDto salvarLocacao(LocacaoDto locacao) {
        ModelMapper mapper = new ModelMapper();
        Locacao locacaoEntidade = mapper.map(locacao, Locacao.class);
        locacaoEntidade = repo.save(locacaoEntidade);

        return mapper.map(locacaoEntidade, LocacaoDto.class);
    }
}