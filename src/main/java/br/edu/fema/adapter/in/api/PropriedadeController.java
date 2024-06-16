package br.edu.fema.adapter.in.api;

import br.edu.fema.domain.propriedade.model.Propriedade;
import br.edu.fema.domain.propriedade.service.PropriedadeService;
import br.edu.fema.infra.framework.domain.ResponseCollectionDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/propriedades")
public class PropriedadeController {

    @Autowired
    private PropriedadeService service;

    @GetMapping
    public ResponseEntity<ResponseCollectionDTO<Propriedade>> findAll() {
        return ResponseEntity.ok(ResponseCollectionDTO.of(service.findAll()));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Propriedade> findByNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(service.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<Propriedade> insert(@RequestBody @Valid Propriedade propriedade) {
        final Propriedade propriedadeInserida = service.insert(propriedade);

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{nome}")
                .buildAndExpand(propriedadeInserida.getNome())
                .toUri();

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(location)
                .header("x-id", propriedadeInserida.getId())
                .body(propriedadeInserida);
    }

    @PutMapping("/{nome}")
    public ResponseEntity<Propriedade> update(@PathVariable("nome") String nome,
                                        @RequestBody @Valid Propriedade propriedade) {
        propriedade.setNome(nome);
        return ResponseEntity.ok(service.update(propriedade));
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Propriedade> deleteByNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(service.deleteByNome(nome));
    }
}
