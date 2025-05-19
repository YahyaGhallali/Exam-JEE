package Yahya.Ghallali.DTO;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {
    private Long id;
    private String nom;
    private String email;

    private List<CreditDTO> creditsDtos;
}
