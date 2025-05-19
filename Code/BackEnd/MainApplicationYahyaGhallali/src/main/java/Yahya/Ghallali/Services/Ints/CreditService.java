package Yahya.Ghallali.Services.Ints;

import java.util.List;

import Yahya.Ghallali.DTO.CreditDTO;

public interface CreditService {
    List<CreditDTO> findAll();
    CreditDTO findById(Long id);
    CreditDTO save(CreditDTO creditDTO);
    void delete(Long id);
} 