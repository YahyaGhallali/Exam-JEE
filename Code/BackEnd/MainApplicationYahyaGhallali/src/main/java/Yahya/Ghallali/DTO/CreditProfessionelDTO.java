package Yahya.Ghallali.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CreditProfessionelDTO extends CreditDTO {
    private String motif;
    private String raisonSociale;
}
