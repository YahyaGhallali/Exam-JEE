package Yahya.Ghallali.DTO;



import java.sql.Date;

import Yahya.Ghallali.Entities.ENUMS.Status;
import lombok.Data;

@Data
public abstract class CreditDTO {
    private Long id;
    private Date dateDemande;
    private Status statut;
    private Date dateAcceptation;
    private Double montant;
    private Integer dureeRemboursement;
    private Double tauxInteret;
}
