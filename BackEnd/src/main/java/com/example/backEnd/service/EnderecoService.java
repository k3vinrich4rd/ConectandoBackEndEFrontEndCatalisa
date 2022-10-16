package com.example.backEnd.service;

import com.example.backEnd.model.EnderecoModel;
import com.example.backEnd.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private IEnderecoRepository iEnderecoRepository;

    public EnderecoModel buscarId(Long id) {
        Optional<EnderecoModel> obj = iEnderecoRepository.findById(id);
        return obj.get();
    }

    public List<EnderecoModel> buscarEnderecos() {
        return iEnderecoRepository.findAll();
    }

    public EnderecoModel cadastraEndereco(EnderecoModel enderecoModel) {
        return iEnderecoRepository.save(enderecoModel);
    }

    public EnderecoModel atualizaEndereco(EnderecoModel enderecoModel, Long id) {
        EnderecoModel newEndereco = buscarId(id); //id e verificado no metodo buscar id em cima
        newEndereco.setLogradouro(enderecoModel.getLogradouro());
        newEndereco.setNumero(enderecoModel.getNumero());
        newEndereco.setBairro(enderecoModel.getBairro());
        newEndereco.setCep(enderecoModel.getCep());
        newEndereco.setResidencialComercial(enderecoModel.getResidencialComercial());

        return iEnderecoRepository.save(newEndereco);
    }

    public void deletaEndereco(Long id) {
        iEnderecoRepository.deleteById(id);
    }
}
