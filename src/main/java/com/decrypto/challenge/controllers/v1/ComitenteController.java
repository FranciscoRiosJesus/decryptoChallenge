package com.decrypto.challenge.controllers.v1;

import com.decrypto.challenge.exceptions.ComitenteNotFoundException;
import com.decrypto.challenge.models.DTOs.ComitenteStatsDTO;
import com.decrypto.challenge.models.entities.Comitente;
import com.decrypto.challenge.service.ComitenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1.0/comitentes")
public class ComitenteController {

    private final ComitenteService service;

    @Autowired
    public ComitenteController(ComitenteService service) {
        this.service = service;
    }

    @GetMapping
    List<Comitente> all() {
        return service.findAll();
    }

    @PostMapping
    Comitente newComitente(@RequestBody Comitente newComitente) {
        return service.save(newComitente);
    }

    @GetMapping("/{id}")
    Comitente one(@PathVariable Long id) {
        try {
            return service.findById(id)
                    .orElseThrow(() -> new ComitenteNotFoundException(id));
        } catch (ComitenteNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    Comitente replaceEmployee(@RequestBody Comitente newComitente, @PathVariable Long id) {

        return service.findById(id)
                .map(comitente -> {
                    comitente.setDescripcion(newComitente.getDescripcion());
                    comitente.setMercados(newComitente.getMercados());
                    return service.save(comitente);
                })
                .orElseGet(() -> {
                    newComitente.setId(id);
                    return service.save(newComitente);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/stats/{id}")
    ComitenteStatsDTO stats(@PathVariable Long id) {
        try {
            return service.stats(id);
        } catch (ComitenteNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
