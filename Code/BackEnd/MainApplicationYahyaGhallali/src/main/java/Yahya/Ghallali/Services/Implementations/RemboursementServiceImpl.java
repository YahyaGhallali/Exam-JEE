package Yahya.Ghallali.Services.Implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Yahya.Ghallali.DTO.RemboursementDTO;
import Yahya.Ghallali.DTO.Mappers.RemboursementMapper;
import Yahya.Ghallali.Entities.Remboursement;
import Yahya.Ghallali.Repositories.RemboursementRepository;
import Yahya.Ghallali.Services.Ints.RemboursementService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RemboursementServiceImpl implements RemboursementService {
    
    private RemboursementRepository remboursementRepository;
    private RemboursementMapper remboursementMapper;
    
    @Override
    public List<RemboursementDTO> findAll() {
        return remboursementRepository.findAll()
                .stream()
                .map(remboursementMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public RemboursementDTO findById(Long id) {
        return remboursementRepository.findById(id)
                .map(remboursementMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Remboursement not found with id: " + id));
    }
    
    @Override
    public RemboursementDTO save(RemboursementDTO remboursementDTO) {
        Remboursement remboursement = remboursementMapper.toEntity(remboursementDTO);
        Remboursement savedRemboursement = remboursementRepository.save(remboursement);
        return remboursementMapper.toDTO(savedRemboursement);
    }
    
    @Override
    public void delete(Long id) {
        remboursementRepository.deleteById(id);
    }
} 