package com.decrypto.challenge.controllers.v1;

import com.decrypto.challenge.exceptions.MercadoNotFoundException;
import com.decrypto.challenge.models.entities.Comitente;
import com.decrypto.challenge.models.entities.Mercado;
import com.decrypto.challenge.service.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1.0/mercados")
public class MercadoController {

    private final MercadoService service;

    @Autowired
    public MercadoController(MercadoService service) {
        this.service = service;
    }

    @GetMapping
    List<Mercado> all() {
        return service.findAll();
    }

    @PostMapping
    Mercado newMercado(@RequestBody Mercado newMercado) {
        return service.save(newMercado);
    }

    @GetMapping("/{id}")
    Mercado one(@PathVariable Long id) throws MercadoNotFoundException {
        return service.findById(id)
                .orElseThrow(() -> new MercadoNotFoundException(id));
    }

    @PutMapping("/{id}")
    Mercado replaceEmployee(@RequestBody Mercado newMercado, @PathVariable Long id) {

        return service.findById(id)
                .map(mercado -> {
                    mercado.setCodigo(newMercado.getCodigo());
                    mercado.setPais(newMercado.getPais());
                    mercado.setDescripcion(newMercado.getDescripcion());
                    return service.save(mercado);
                })
                .orElseGet(() -> {
                    newMercado.setId(id);
                    return service.save(newMercado);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        service.deleteById(id);
    }
}
