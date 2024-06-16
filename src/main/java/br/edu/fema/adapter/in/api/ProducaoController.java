package br.edu.fema.adapter.in.api;

import br.edu.fema.domain.producao.model.Producao;
import br.edu.fema.domain.producao.service.ProducaoService;
import br.edu.fema.infra.framework.domain.ResponseCollectionDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/producoes")
public class ProducaoController {

    @Autowired
    private ProducaoService service;

    @GetMapping
    public ResponseEntity<ResponseCollectionDTO<Producao>> findAll() {
        return ResponseEntity.ok(ResponseCollectionDTO.of(service.findAll()));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Producao> findByNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(service.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<Producao> insert(@RequestBody @Valid Producao producao) {
        final Producao producaoInserida = service.insert(producao);

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{nome}")
                .buildAndExpand(producaoInserida.getNome())
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(location)
                .header("x-id", producaoInserida.getId())
                .body(producaoInserida);
    }

    @PutMapping("/{nome}")
    public ResponseEntity<Producao> update(@PathVariable("nome") String nome,
                                        @RequestBody @Valid Producao producao) {
        producao.setNome(nome);
        return ResponseEntity.ok(service.update(producao));
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Producao> deleteByNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(service.deleteByNome(nome));
    }
}
