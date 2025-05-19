package Yahya.Ghallali.Entities;

import Yahya.Ghallali.Entities.ENUMS.Bien;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DiscriminatorValue("CreditImmobilier")
public class CreditImmobilier extends Credit {
    @Enumerated(EnumType.STRING)
    private Bien typeBien;
}
