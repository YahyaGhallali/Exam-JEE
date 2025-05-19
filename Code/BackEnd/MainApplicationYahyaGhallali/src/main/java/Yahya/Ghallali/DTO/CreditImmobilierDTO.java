package Yahya.Ghallali.DTO;

import Yahya.Ghallali.Entities.ENUMS.Bien;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditImmobilierDTO extends CreditDTO {
    private Bien typeBien;
}
