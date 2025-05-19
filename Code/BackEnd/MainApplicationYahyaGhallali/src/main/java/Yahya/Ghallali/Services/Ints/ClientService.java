package Yahya.Ghallali.Services.Ints;

import java.util.List;

import Yahya.Ghallali.DTO.ClientDTO;

public interface ClientService {
    List<ClientDTO> findAll();
    ClientDTO findById(Long id);
    ClientDTO save(ClientDTO clientDTO);
    void delete(Long id);
}
