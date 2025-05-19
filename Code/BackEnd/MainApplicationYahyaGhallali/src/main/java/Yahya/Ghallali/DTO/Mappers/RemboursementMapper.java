package Yahya.Ghallali.DTO.Mappers;

import org.mapstruct.Mapper;

import Yahya.Ghallali.DTO.RemboursementDTO;
import Yahya.Ghallali.Entities.Remboursement;

@Mapper(componentModel = "spring")
public interface RemboursementMapper {
    RemboursementDTO toDTO(Remboursement remboursement);
    Remboursement toEntity(RemboursementDTO remboursementDTO);
}