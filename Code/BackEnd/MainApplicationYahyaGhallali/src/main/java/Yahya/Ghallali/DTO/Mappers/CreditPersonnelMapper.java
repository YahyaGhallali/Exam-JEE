package Yahya.Ghallali.DTO.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import Yahya.Ghallali.DTO.ClientDTO;
import Yahya.Ghallali.DTO.CreditDTO;
import Yahya.Ghallali.DTO.CreditPersonnelDTO;
import Yahya.Ghallali.Entities.Client;
import Yahya.Ghallali.Entities.Credit;
import Yahya.Ghallali.Entities.CreditPersonnel;

@Mapper(componentModel = "spring", uses = {CreditMapper.class})
public interface CreditPersonnelMapper {
    @Mapping(target = "remboursements", ignore = true)
    CreditPersonnelDTO toDTO(CreditPersonnel creditPersonnel);
    @Mapping(target = "remboursements", ignore = true)
    CreditPersonnel toEntity(CreditPersonnelDTO creditPersonnelDTO);
}
