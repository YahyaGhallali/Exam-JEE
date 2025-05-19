package Yahya.Ghallali.Services.Implementations;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Yahya.Ghallali.DTO.ClientDTO;
import Yahya.Ghallali.Services.Ints.ClientService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
@CrossOrigin("*")
public class ClientController {

    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> findAll() {
        return clientService.findAll();
    }

    
}
