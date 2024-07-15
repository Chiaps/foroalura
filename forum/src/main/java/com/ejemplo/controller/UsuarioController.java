package com.ejemplo.miproyecto.controller;

import com.ejemplo.miproyecto.model.Usuario;
import com.ejemplo.miproyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/username/{username}")
    public ResponseEntity<Usuario> obtenerUsuarioPorUsername(@PathVariable String username) {
        Optional<Usuario> usuario = usuarioService.findByUsername(username);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Usuario createUser(@RequestBody Usuario usuario) {
        return usuarioService.createUser(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.getUserById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usuarioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
