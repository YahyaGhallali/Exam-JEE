package Yahya.Ghallali.Services.Ints;

import java.util.List;

import Yahya.Ghallali.DTO.RemboursementDTO;

public interface RemboursementService {
    List<RemboursementDTO> findAll();
    RemboursementDTO findById(Long id);
    RemboursementDTO save(RemboursementDTO remboursementDTO);
    void delete(Long id);
} 