package br.edu.fema.adapter.in.api;

import br.edu.fema.domain.cadastro.model.Cadastro;
import br.edu.fema.domain.cadastro.service.CadastroService;
import br.edu.fema.infra.framework.domain.ResponseCollectionDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {

    @Autowired
    private CadastroService service;

    @GetMapping
    public ResponseEntity<ResponseCollectionDTO<Cadastro>> findAll() {
        return ResponseEntity.ok(ResponseCollectionDTO.of(service.findAll()));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cadastro> findByCpf(@PathVariable("cpf") String cpf) {
        return ResponseEntity.ok(service.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Cadastro> insert(@RequestBody @Valid Cadastro cadastro) {
        final Cadastro cadastroInserido = service.insert(cadastro);

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{cpf}")
                .buildAndExpand(cadastroInserido.getCpf())
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(location)
                .header("x-id", cadastroInserido.getId())
                .body(cadastroInserido);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Cadastro> update(@PathVariable("cpf") String cpf,
                                        @RequestBody @Valid Cadastro cadastro) {
        cadastro.setCpf(cpf);
        return ResponseEntity.ok(service.update(cadastro));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Cadastro> deleteByCpf(@PathVariable("cpf") String cpf) {
        return ResponseEntity.ok(service.deleteByCpf(cpf));
    }
}
