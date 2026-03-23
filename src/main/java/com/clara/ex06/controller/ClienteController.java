package com.clara.ex06.controller;

import com.clara.ex06.models.ClienteModel;
import com.clara.ex06.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll(){
        List<ClienteModel> clientes = clienteService.findAll();
        return ResponseEntity.ok().body(clientes);
    }

    @PostMapping
    public ResponseEntity<ClienteModel> criar (@RequestBody ClienteModel cliente){
        ClienteModel requeste = clienteService.criar(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{/id}")
    public Optional<ClienteModel> findById(@PathVariable Long id){
        return clienteService.findById(id);
    }

}
