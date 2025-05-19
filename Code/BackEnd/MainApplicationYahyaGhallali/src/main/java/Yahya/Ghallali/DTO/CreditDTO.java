package Yahya.Ghallali.DTO;

import java.sql.Date;
import java.util.List;

import Yahya.Ghallali.Entities.ENUMS.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private Status statut;
    private Date dateAcceptation;
    private Double montant;
    private Integer dureeRemboursement;
    private Double tauxInteret;

    private List<RemboursementDTO> remboursements;
}
