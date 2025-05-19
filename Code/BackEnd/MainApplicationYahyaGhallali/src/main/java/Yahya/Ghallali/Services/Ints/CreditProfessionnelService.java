package Yahya.Ghallali.Services.Ints;

import java.util.List;

import Yahya.Ghallali.DTO.CreditProfessionnelDTO;

public interface CreditProfessionnelService {
    List<CreditProfessionnelDTO> findAll();
    CreditProfessionnelDTO findById(Long id);
    CreditProfessionnelDTO save(CreditProfessionnelDTO creditProfessionnelDTO);
    void delete(Long id);
} 