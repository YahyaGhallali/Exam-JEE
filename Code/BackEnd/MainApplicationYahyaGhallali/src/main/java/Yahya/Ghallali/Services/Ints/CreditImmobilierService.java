package Yahya.Ghallali.Services.Ints;

import java.util.List;

import Yahya.Ghallali.DTO.CreditImmobilierDTO;

public interface CreditImmobilierService {
    List<CreditImmobilierDTO> findAll();
    CreditImmobilierDTO findById(Long id);
    CreditImmobilierDTO save(CreditImmobilierDTO creditImmobilierDTO);
    void delete(Long id);
} 