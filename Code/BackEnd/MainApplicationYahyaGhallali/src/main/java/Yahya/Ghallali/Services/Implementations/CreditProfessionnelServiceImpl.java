// package Yahya.Ghallali.Services.Implementations;

// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.stereotype.Service;

// import Yahya.Ghallali.DTO.CreditProfessionnelDTO;
// import Yahya.Ghallali.DTO.Mappers.CreditMapper;
// import Yahya.Ghallali.Entities.CreditProfessionnel;
// import Yahya.Ghallali.Repositories.CreditProfessionnelRepository;
// import Yahya.Ghallali.Services.Ints.CreditProfessionnelService;
// import lombok.AllArgsConstructor;

// @Service
// @AllArgsConstructor
// public class CreditProfessionnelServiceImpl implements CreditProfessionnelService {
    
//     private CreditProfessionnelRepository creditProfessionnelRepository;
//     private CreditMapper creditMapper;
    
//     @Override
//     public List<CreditProfessionnelDTO> findAll() {
//         return creditProfessionnelRepository.findAll()
//                 .stream()
//                 .map(credit -> (CreditProfessionnelDTO) creditMapper.toDTO(credit))
//                 .collect(Collectors.toList());
//     }
    
//     @Override
//     public CreditProfessionnelDTO findById(Long id) {
//         return creditProfessionnelRepository.findById(id)
//                 .map(credit -> (CreditProfessionnelDTO) creditMapper.toDTO(credit))
//                 .orElseThrow(() -> new RuntimeException("CreditProfessionnel not found with id: " + id));
//     }
    
//     @Override
//     public CreditProfessionnelDTO save(CreditProfessionnelDTO creditProfessionnelDTO) {
//         CreditProfessionnel creditProfessionnel = (CreditProfessionnel) creditMapper.toEntity(creditProfessionnelDTO);
//         CreditProfessionnel savedCreditProfessionnel = creditProfessionnelRepository.save(creditProfessionnel);
//         return (CreditProfessionnelDTO) creditMapper.toDTO(savedCreditProfessionnel);
//     }
    
//     @Override
//     public void delete(Long id) {
//         creditProfessionnelRepository.deleteById(id);
//     }
// } 