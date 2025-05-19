package Yahya.Ghallali.DTO;

import java.sql.Date;
import Yahya.Ghallali.Entities.ENUMS.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemboursementDTO {
    private Long id;
    private Date date;
    private Double montant;
    private Type type;
    
    private CreditDTO creditDto;
}