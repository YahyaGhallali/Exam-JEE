package Yahya.Ghallali.DTO.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import Yahya.Ghallali.DTO.ClientDTO;
import Yahya.Ghallali.DTO.CreditDTO;
import Yahya.Ghallali.DTO.CreditPersonnelDTO;
import Yahya.Ghallali.DTO.CreditProfessionnelDTO;
import Yahya.Ghallali.Entities.Client;
import Yahya.Ghallali.Entities.Credit;
import Yahya.Ghallali.Entities.CreditPersonnel;
import Yahya.Ghallali.Entities.CreditProfessionnel;

@Mapper(componentModel = "spring", uses = {CreditMapper.class})
public interface CreditProfessionnelMapper {
    @Mapping(target = "remboursements", ignore = true)
    CreditProfessionnelDTO toDTO(CreditProfessionnel creditProfessionnel);
    @Mapping(target = "remboursements", ignore = true)
    CreditProfessionnel toEntity(CreditProfessionnelDTO creditProfessionnelDTO);
}
