package Yahya.Ghallali.DTO;

import Yahya.Ghallali.Entities.ENUMS.Bien;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreditImmobilierDTO extends CreditDTO {
    private Bien typeBien;
}
