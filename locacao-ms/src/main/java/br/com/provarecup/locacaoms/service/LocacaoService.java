package br.com.provarecup.locacaoms.service;

import java.util.List;
import java.util.Optional;

import br.com.provarecup.locacaoms.Compatilhado.LocacaoDto;

public interface LocacaoService {

    LocacaoDto criarLocacao(LocacaoDto locacao);
    List<LocacaoDto> obterTodos();
    Optional<LocacaoDto> obterPorId(String id);
    List<LocacaoDto> obterPorLocacao(String locacao);
    void removerLocacao(String id);
    LocacaoDto atualizarLocacao(String id, LocacaoDto locacao);

}
