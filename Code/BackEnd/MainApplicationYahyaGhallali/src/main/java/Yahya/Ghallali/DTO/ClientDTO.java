package Yahya.Ghallali.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {
    private Long id;
    private String nom;
    private String email;
}
