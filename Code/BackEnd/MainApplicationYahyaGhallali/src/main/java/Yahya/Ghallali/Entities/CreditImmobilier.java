package Yahya.Ghallali.Entities;

import Yahya.Ghallali.Entities.ENUMS.Bien;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("CreditImmobilier")
public class CreditImmobilier extends Credit {
    @Enumerated(EnumType.STRING)
    private Bien typeBien;
}
