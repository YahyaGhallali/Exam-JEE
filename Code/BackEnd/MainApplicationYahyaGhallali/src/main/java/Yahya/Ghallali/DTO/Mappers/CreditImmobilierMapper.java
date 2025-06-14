package Yahya.Ghallali.DTO.Mappers;

import org.mapstruct.Mapper;

import Yahya.Ghallali.DTO.CreditImmobilierDTO;
import Yahya.Ghallali.Entities.CreditImmobilier;

@Mapper(componentModel = "spring")
public interface CreditImmobilierMapper {
    // @Mapping(target = "remboursements", ignore = true)
    CreditImmobilierDTO toDTO(CreditImmobilier creditImmobilier);
    CreditImmobilier toEntity(CreditImmobilierDTO creditImmobilierDTO);
}