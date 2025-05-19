package Yahya.Ghallali.Services.Ints;

import java.util.List;

import Yahya.Ghallali.DTO.CreditPersonnelDTO;

public interface CreditPersonnelService {
    List<CreditPersonnelDTO> findAll();
    CreditPersonnelDTO findById(Long id);
    CreditPersonnelDTO save(CreditPersonnelDTO creditPersonnelDTO);
    void delete(Long id);
} 