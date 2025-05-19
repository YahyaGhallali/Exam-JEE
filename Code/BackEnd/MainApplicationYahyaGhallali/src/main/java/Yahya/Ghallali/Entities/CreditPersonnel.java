package Yahya.Ghallali.Entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DiscriminatorValue("CreditPersonnel")
public class CreditPersonnel extends Credit {
    private String motif;
}
