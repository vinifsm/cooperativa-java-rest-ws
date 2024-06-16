package br.edu.fema.domain.usuario.service;

import br.edu.fema.domain.usuario.exceptions.UsuarioDuplicatedException;
import br.edu.fema.domain.usuario.exceptions.UsuarioNotFoundException;
import br.edu.fema.domain.usuario.model.Usuario;
import br.edu.fema.domain.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new UsuarioNotFoundException(email));
    }

    public Usuario insert(Usuario usuario) {
        final Optional<Usuario> usuarioRecuperado = repository.findByEmail(usuario.getEmail());

        if (usuarioRecuperado.isPresent()) {
            throw new UsuarioDuplicatedException(usuario.getEmail());
        }

        return repository.insert(usuario);
    }

    public Usuario update(Usuario usuario) {
        final Usuario usuarioRecuperado = repository.findByEmail(usuario.getEmail()).orElseThrow(() -> new UsuarioNotFoundException(usuario.getEmail()));

        usuario.setId(usuarioRecuperado.getId());

        return repository.update(usuario);
    }

    public Usuario deleteByEmail(String email) {
        return repository.deleteByEmail(email).orElseThrow(() -> new UsuarioNotFoundException(email));
    }
}
