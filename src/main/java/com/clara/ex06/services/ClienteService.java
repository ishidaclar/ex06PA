package com.clara.ex06.services;

import com.clara.ex06.models.ClienteModel;
import com.clara.ex06.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> findAll(){
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> findById(Long id){
        return clienteRepository.findById(id);
    }

    public ClienteModel criar (ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    public ClienteModel atualizar (Long id, ClienteModel cliente){
        ClienteModel requeste = clienteRepository.findById(id).get();
        requeste.setNome(cliente.getNome());
        return clienteRepository.save(requeste);
    }

    public void deletar (Long id){
        clienteRepository.deleteById(id);
    }

}
