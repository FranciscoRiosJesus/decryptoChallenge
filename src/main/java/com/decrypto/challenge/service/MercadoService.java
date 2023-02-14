package com.decrypto.challenge.service;

import com.decrypto.challenge.models.entities.Mercado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MercadoService {
    List<Mercado> findAll();

    Mercado save(Mercado newMercado);

    Optional<Mercado> findById(Long id);

    void deleteById(Long id);
}
