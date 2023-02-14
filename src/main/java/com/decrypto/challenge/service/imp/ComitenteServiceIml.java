package com.decrypto.challenge.service.imp;

import com.decrypto.challenge.exceptions.ComitenteNotFoundException;
import com.decrypto.challenge.models.DTOs.ComitenteStatsDTO;
import com.decrypto.challenge.models.entities.Comitente;
import com.decrypto.challenge.repositories.database.ComitenteRepositoy;
import com.decrypto.challenge.service.ComitenteService;
import com.decrypto.challenge.service.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComitenteServiceIml implements ComitenteService {

    private final ComitenteRepositoy repository;
    private final MercadoService mercadoService;

    @Autowired
    public ComitenteServiceIml(ComitenteRepositoy repository, MercadoService mercadoService) {
        this.repository = repository;
        this.mercadoService = mercadoService;
    }


    @Override
    public List<Comitente> findAll() {
        return repository.findAll();
    }

    @Override
    public Comitente save(Comitente newComitente) {
        return repository.save(newComitente);
    }

    @Override
    public Optional<Comitente> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ComitenteStatsDTO stats(Long id) throws ComitenteNotFoundException {
        Comitente comitente = repository.findById(id)
                .orElseThrow(() -> new ComitenteNotFoundException(id));

        List<Object> mercados = mercadoService.getMercadosByComitente(comitente.getId());

        ComitenteStatsDTO comitenteStatsDTO = new ComitenteStatsDTO();
    }
}
