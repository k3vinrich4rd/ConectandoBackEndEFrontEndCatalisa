package com.example.backEnd.controller;

import com.example.backEnd.model.EnderecoModel;
import com.example.backEnd.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/enderecos")
public class EnderecoController {


    @Autowired
    private EnderecoService enderecoService;


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
    public ResponseEntity<List<EnderecoModel>> buscarTudo() {
        return ResponseEntity.ok(enderecoService.buscarEnderecos());
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/pesquisaid/{id}")
    public ResponseEntity<EnderecoModel> buscaPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(enderecoService.buscarId(id));
    }


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping(path = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EnderecoModel> cadastraEndereco(@RequestBody EnderecoModel enderecoModel) {
        return ResponseEntity.ok(enderecoService.cadastraEndereco(enderecoModel));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PatchMapping(path = "/put/{id}")
    public ResponseEntity<EnderecoModel> atualizaEndereco(@RequestBody EnderecoModel enderecoModel, @PathVariable Long id) {
        EnderecoModel enderecoNewObj = enderecoService.atualizaEndereco(enderecoModel, id);
        return ResponseEntity.ok().body(enderecoNewObj);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/delete/{id}")
    public void deletaConta(@PathVariable Long id) {
        enderecoService.deletaEndereco(id);
    }

}
