package br.com.tshirt.http.client;

import br.com.tshirt.dao.response.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCep", url = "${feign.viaCep}")
public interface ViaCepFeign {
    @GetMapping(value = "/{cep}/json")
    Endereco buscarCep(@PathVariable("cep") String cep);

}
