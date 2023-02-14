package com.decrypto.challenge.repositories.database;

import com.decrypto.challenge.models.entities.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoRepository  extends JpaRepository<Mercado, Long> {
}
