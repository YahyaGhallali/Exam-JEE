package Yahya.Ghallali.DTO.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import Yahya.Ghallali.DTO.ClientDTO;
import Yahya.Ghallali.Entities.Client;

@Mapper(componentModel = "spring", uses = {CreditMapper.class})
public interface ClientMapper {
    @Mapping(target = "creditsDtos", source = "credits")
    ClientDTO toDTO(Client client);
    Client toEntity(ClientDTO clientDTO);
}
