package com.decrypto.challenge.models.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class ComitenteStatsDTO {
    private String country;
    private List<Object> marketsDTO;
}
