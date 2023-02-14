package com.decrypto.challenge.repositories.database;

import com.decrypto.challenge.models.entities.Comitente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComitenteRepositoy  extends JpaRepository<Comitente, Long> {
}
