package Yahya.Ghallali.Services.Implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Yahya.Ghallali.DTO.ClientDTO;
import Yahya.Ghallali.DTO.Mappers.ClientMapper;
import Yahya.Ghallali.Entities.Client;
import Yahya.Ghallali.Repositories.ClientRepository;
import Yahya.Ghallali.Services.Ints.ClientService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;
    
    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public ClientDTO findById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
    }
    
    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toDTO(savedClient);
    }
    
    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

} 