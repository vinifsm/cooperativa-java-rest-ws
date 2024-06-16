package br.edu.fema.domain.usuario.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.edu.fema.domain.usuario.model.Usuario;

@Repository
public class UsuarioRepository {

    private static final Map<String, Usuario> USUARIOS = new LinkedHashMap<>();

    public List<Usuario> findAll() {
        return List.copyOf(USUARIOS.values());
    }

    public Optional<Usuario> findByEmail(String email) {
        return Optional.ofNullable(USUARIOS.get(email));
    }

    public Usuario insert(Usuario usuario) {
        USUARIOS.putIfAbsent(usuario.getEmail(), usuario);
        return usuario;
    }

    public Usuario update(Usuario usuario) {
        USUARIOS.put(usuario.getEmail(), usuario);
        return usuario;
    }

    public Optional<Usuario> deleteByEmail(String email) {
        return Optional.ofNullable(USUARIOS.remove(email));
    }
}
