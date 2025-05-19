package Yahya.Ghallali.DTO;

import java.sql.Date;

import Yahya.Ghallali.Entities.ENUMS.Type;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemboursementDTO {
    private Long id;
    private Date date;
    private Double montant;
    private Type type;
    private CreditDTO credit;
}