package Yahya.Ghallali.Services.Implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Yahya.Ghallali.DTO.CreditPersonnelDTO;
import Yahya.Ghallali.DTO.Mappers.CreditMapper;
import Yahya.Ghallali.Entities.CreditPersonnel;
import Yahya.Ghallali.Repositories.CreditPersonnelRepository;
import Yahya.Ghallali.Services.Ints.CreditPersonnelService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreditPersonnelServiceImpl implements CreditPersonnelService {
    
    private CreditPersonnelRepository creditPersonnelRepository;
    private CreditMapper creditMapper;
    
    @Override
    public List<CreditPersonnelDTO> findAll() {
        return creditPersonnelRepository.findAll()
                .stream()
                .map(credit -> (CreditPersonnelDTO) creditMapper.toDTO(credit))
                .collect(Collectors.toList());
    }
    
    @Override
    public CreditPersonnelDTO findById(Long id) {
        return creditPersonnelRepository.findById(id)
                .map(credit -> (CreditPersonnelDTO) creditMapper.toDTO(credit))
                .orElseThrow(() -> new RuntimeException("CreditPersonnel not found with id: " + id));
    }
    
    @Override
    public CreditPersonnelDTO save(CreditPersonnelDTO creditPersonnelDTO) {
        // CreditPersonnel creditPersonnel = (CreditPersonnel) creditMapper.toEntity(creditPersonnelDTO);
        // CreditPersonnel savedCreditPersonnel = creditPersonnelRepository.save(creditPersonnel);
        // return (CreditPersonnelDTO) creditMapper.toDTO(savedCreditPersonnel);
        return null;
    }
    
    @Override
    public void delete(Long id) {
        creditPersonnelRepository.deleteById(id);
    }
} 