package br.edu.fema.adapter.in.api;

import br.edu.fema.domain.usuario.model.Usuario;
import br.edu.fema.domain.usuario.service.UsuarioService;
import br.edu.fema.infra.framework.domain.ResponseCollectionDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<ResponseCollectionDTO<Usuario>> findAll() {
        return ResponseEntity.ok(ResponseCollectionDTO.of(service.findAll()));
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> findByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody @Valid Usuario usuario) {
        final Usuario usuarioInserido = service.insert(usuario);

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(usuarioInserido.getEmail())
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(location)
                .header("x-id", usuarioInserido.getId())
                .body(usuarioInserido);
    }

    @PutMapping("/{email}")
    public ResponseEntity<Usuario> update(@PathVariable("email") String email,
                                        @RequestBody @Valid Usuario usuario) {
        usuario.setEmail(email);
        return ResponseEntity.ok(service.update(usuario));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Usuario> deleteByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(service.deleteByEmail(email));
    }
}
