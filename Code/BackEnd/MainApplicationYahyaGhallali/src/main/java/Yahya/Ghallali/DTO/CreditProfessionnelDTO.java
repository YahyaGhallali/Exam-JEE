package Yahya.Ghallali.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreditProfessionnelDTO extends CreditDTO {
    private String motif;
    private String raisonSociale;
} 