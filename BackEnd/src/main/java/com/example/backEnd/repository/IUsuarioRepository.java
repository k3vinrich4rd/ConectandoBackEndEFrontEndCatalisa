package com.example.backEnd.repository;

import com.example.backEnd.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    List<UsuarioModel> findByNomeUsuario(String nomeUsuario);
}
