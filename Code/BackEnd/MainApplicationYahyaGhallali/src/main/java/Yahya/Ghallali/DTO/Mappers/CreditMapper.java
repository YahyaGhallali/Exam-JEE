package Yahya.Ghallali.DTO.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import Yahya.Ghallali.DTO.CreditDTO;
import Yahya.Ghallali.Entities.Credit;

@Mapper(componentModel = "spring", uses = {RemboursementMapper.class})
public interface CreditMapper {
    @Mapping(target = "remboursements", source = "remboursements")
    CreditDTO toDTO(Credit credit);
    // @Mapping(target = "remboursements", ignore = true)
    // Credit toEntity(CreditDTO creditDTO);
}