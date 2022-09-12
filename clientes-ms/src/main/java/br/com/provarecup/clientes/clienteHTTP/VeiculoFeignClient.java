package br.com.provarecup.clientes.clienteHTTP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.provarecup.clientes.Compartilhado.Veiculo;

@FeignClient(name= "locacao-ms", fallback = VeiculoFeignClientFallback.class)
public interface VeiculoFeignClient {
    @GetMapping(path = "/api/veiculo/{marca}/lista")
    List<Veiculo> obterVeiculo(@PathVariable String marca);   
}

@Component
class VeiculoFeignClientFallback implements VeiculoFeignClient {

    @Override
    public List<Veiculo> obterVeiculo(String marca) {
        return new ArrayList<>();
    }

}
