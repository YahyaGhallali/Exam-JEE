package Yahya.Ghallali.DTO.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import Yahya.Ghallali.DTO.ClientDTO;
import Yahya.Ghallali.DTO.CreditDTO;
import Yahya.Ghallali.Entities.Client;
import Yahya.Ghallali.Entities.Credit;

@Mapper(componentModel = "spring", uses = {CreditMapper.class})
public interface ClientMapper {
    @Mapping(target = "creditsDtos", source = "credits")
    ClientDTO toDTO(Client client);
    
    @Mapping(target = "credits", ignore = true)
    Client toEntity(ClientDTO clientDTO);
}
