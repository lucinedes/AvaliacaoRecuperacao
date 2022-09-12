package br.com.provarecup.locacaoms.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.provarecup.locacaoms.model.Veiculo;

@Repository
public interface VeiculoRepositorio extends MongoRepository<Veiculo,String>{
    List<Veiculo> findByMarca(String marca);
    
}
