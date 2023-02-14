package com.decrypto.challenge.models.entities;

import com.decrypto.challenge.models.enums.Pais;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "MERCADO")
@Data
public class Mercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private String descripcion;

    @Enumerated (EnumType.STRING)
    private Pais pais;
}
