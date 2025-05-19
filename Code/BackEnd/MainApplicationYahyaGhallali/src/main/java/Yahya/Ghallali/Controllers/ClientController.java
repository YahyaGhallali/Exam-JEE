package Yahya.Ghallali.Controllers;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    public ClientDTO save(@RequestBody ClientDTO clientDTO) {
        return clientService.save(clientDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }
    
}
