package Yahya.Ghallali.Services.Implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Yahya.Ghallali.DTO.CreditImmobilierDTO;
import Yahya.Ghallali.DTO.Mappers.CreditImmobilierMapper;
import Yahya.Ghallali.Entities.CreditImmobilier;
import Yahya.Ghallali.Repositories.CreditImmobilierRepository;
import Yahya.Ghallali.Services.Ints.CreditImmobilierService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreditImmobilierServiceImpl implements CreditImmobilierService {
    
    private CreditImmobilierRepository creditImmobilierRepository;
    private CreditImmobilierMapper creditImmobilierMapper;
    
    @Override
    public List<CreditImmobilierDTO> findAll() {
        return creditImmobilierRepository.findAll()
                .stream()
                .map(creditImmobilierMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public CreditImmobilierDTO findById(Long id) {
        return creditImmobilierRepository.findById(id)
                .map(creditImmobilierMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("CreditImmobilier not found with id: " + id));
    }
    
    @Override
    public CreditImmobilierDTO save(CreditImmobilierDTO creditImmobilierDTO) {
        CreditImmobilier creditImmobilier = creditImmobilierMapper.toEntity(creditImmobilierDTO);
        CreditImmobilier savedCreditImmobilier = creditImmobilierRepository.save(creditImmobilier);
        return creditImmobilierMapper.toDTO(savedCreditImmobilier);
    }
    
    @Override
    public void delete(Long id) {
        creditImmobilierRepository.deleteById(id);
    }
} 