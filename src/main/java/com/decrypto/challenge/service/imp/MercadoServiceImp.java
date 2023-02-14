package com.decrypto.challenge.service.imp;

import com.decrypto.challenge.models.entities.Mercado;
import com.decrypto.challenge.repositories.database.MercadoRepository;
import com.decrypto.challenge.service.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercadoServiceImp implements MercadoService {

    private final MercadoRepository repository;

    @Autowired
    public MercadoServiceImp(MercadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Mercado> findAll() {
        return repository.findAll();
    }

    @Override
    public Mercado save(Mercado newMercado) {
        return repository.save(newMercado);
    }

    @Override
    public Optional<Mercado> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
