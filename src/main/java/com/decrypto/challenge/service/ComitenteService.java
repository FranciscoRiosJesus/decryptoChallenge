package com.decrypto.challenge.service;

import com.decrypto.challenge.exceptions.ComitenteNotFoundException;
import com.decrypto.challenge.models.DTOs.ComitenteStatsDTO;
import com.decrypto.challenge.models.entities.Comitente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ComitenteService {
    List<Comitente> findAll();

    Comitente save(Comitente newComitente);

    Optional<Comitente> findById(Long id);

    void deleteById(Long id);

    ComitenteStatsDTO stats(Long id) throws ComitenteNotFoundException;
}
