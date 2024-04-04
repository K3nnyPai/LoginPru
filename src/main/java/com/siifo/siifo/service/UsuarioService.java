package com.siifo.siifo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.siifo.siifo.entity.Usuario;
import com.siifo.siifo.repository.UsuarioRepository;

@Service
@Lazy
public class UsuarioService {
         // Otros métodos de gestión de usuarios fusionados desde UsuarioService
         @Autowired
         UsuarioRepository userRepository;
     
         public List<Usuario> getUsuarioList() {
             return (List<Usuario>) userRepository.findAll();
         }
     
         public Optional<Usuario> getUsuario(Long id) {
             return userRepository.findById(id);
         }
     
         public int saveOrUpdateUsuario(Usuario usuario) {
             Usuario savedUsuario = userRepository.save(usuario);
             return savedUsuario != null ? 1 : 0;
         }
     
         public void deleteUsuario(Long id) {
             userRepository.deleteById(id);
         }
}
