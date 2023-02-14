package com.decrypto.challenge.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMITENTES")
@Data
public class Comitente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Mercado> mercados;
}
