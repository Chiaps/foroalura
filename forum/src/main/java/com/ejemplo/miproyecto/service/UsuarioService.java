package com.ejemplo.miproyecto.service;

import com.ejemplo.miproyecto.model.Usuario;
import com.ejemplo.miproyecto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para encontrar por username
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    // Método para crear un nuevo usuario
    public Usuario createUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Método para encontrar un usuario por ID
    public Optional<Usuario> getUserById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Método para eliminar un usuario por ID
    public void deleteUser(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Otros métodos CRUD pueden ser añadidos aquí
}
