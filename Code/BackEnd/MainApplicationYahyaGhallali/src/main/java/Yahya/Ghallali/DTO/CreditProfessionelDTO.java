package Yahya.Ghallali.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditProfessionelDTO extends CreditDTO {
    private String motif;
    private String raisonSociale;
}
