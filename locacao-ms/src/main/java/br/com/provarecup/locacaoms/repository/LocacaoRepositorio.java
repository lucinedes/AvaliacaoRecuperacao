package br.com.provarecup.locacaoms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.provarecup.locacaoms.model.Locacao;

public interface LocacaoRepositorio extends MongoRepository<Locacao,String>{
   
    List<Locacao> findByIdList(String idLocação);

    Optional<Locacao> findByLocacao(Optional<Locacao> idlocacao);
    
}
