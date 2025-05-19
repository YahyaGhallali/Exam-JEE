package Yahya.Ghallali.Services.Implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Yahya.Ghallali.DTO.CreditDTO;
import Yahya.Ghallali.DTO.Mappers.CreditMapper;
import Yahya.Ghallali.Entities.Credit;
import Yahya.Ghallali.Repositories.CreditRepository;
import Yahya.Ghallali.Services.Ints.CreditService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreditServiceImpl implements CreditService {
    
    private CreditRepository creditRepository;
    private CreditMapper creditMapper;
    
    @Override
    public List<CreditDTO> findAll() {
        return creditRepository.findAll()
                .stream()
                .map(creditMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public CreditDTO findById(Long id) {
        return creditRepository.findById(id)
                .map(creditMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Credit not found with id: " + id));
    }
    
    @Override
    public CreditDTO save(CreditDTO creditDTO) {
        // Problem here mapper structure
        // Credit credit = creditMapper.toEntity(creditDTO);
        // Credit savedCredit = creditRepository.save(credit);
        // return creditMapper.toDTO(savedCredit);
        return null;
    }
    
    @Override
    public void delete(Long id) {
        creditRepository.deleteById(id);
    }
} 