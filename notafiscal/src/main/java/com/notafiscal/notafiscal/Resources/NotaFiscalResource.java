package com.notafiscal.notafiscal.Resources;

import com.notafiscal.notafiscal.service.NotaFiscalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nota-fiscal")
public class NotaFiscalResource {

    private NotaFiscalService notaFiscalService;

    public NotaFiscalResource(NotaFiscalService notaFiscalService){
        this.notaFiscalService = notaFiscalService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<String> imprimirNotaFiscalDoId(@PathVariable Integer id){
        return new ResponseEntity<>(notaFiscalService.criarNotaFiscalString(id), HttpStatus.ACCEPTED);
    }

}

