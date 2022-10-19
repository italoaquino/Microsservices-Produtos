package com.notafiscal.notafiscal.feingClients;

import com.notafiscal.notafiscal.FeingModels.ProdutoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "hr-produtos", path="/api/produtos")
public interface ProdutoFeingClient {

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<ProdutoDTO> getById(@PathVariable Integer id);

}
