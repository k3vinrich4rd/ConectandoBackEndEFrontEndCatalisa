package com.example.backEnd.service;

import com.example.backEnd.model.UsuarioModel;
import com.example.backEnd.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;


    public List<UsuarioModel> buscarNomes() {
        return iUsuarioRepository.findAll();
    }

    public UsuarioModel findById(Long id) {
        Optional<UsuarioModel> obj = iUsuarioRepository.findById(id);
        return obj.get();
    }

    public List<UsuarioModel> findByNomeUsuario(String nomeUsuario) {
        return iUsuarioRepository.findByNomeUsuario(nomeUsuario);
    }

    public UsuarioModel cadastrarUsuario(UsuarioModel usuarioModel) {
        return iUsuarioRepository.save(usuarioModel);
    }

    public UsuarioModel alterarCadUsuario(UsuarioModel usuarioModel, Long id) {
        UsuarioModel newUsuario = findById(id);
        newUsuario.setNomeUsuario(usuarioModel.getNomeUsuario());
        newUsuario.setCpf(usuarioModel.getCpf());
        newUsuario.setDataNascimento(usuarioModel.getDataNascimento());
        newUsuario.setEmail(newUsuario.getEmail());

        return iUsuarioRepository.save(newUsuario);
    }

    public void deletarUsuario(Long id) {
        iUsuarioRepository.deleteById(id);
    }
}
