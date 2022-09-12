package br.com.provarecup.clientes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.provarecup.clientes.model.ClienteDto;



@Repository
public interface ClienteRepository extends MongoRepository<ClienteDto, String> {
    
}
