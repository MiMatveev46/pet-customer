package pet.customer.domain.dto.rest.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PersonInfo {
    @NotBlank
    @Pattern(regexp = "^[A-Za-z][A-Za-z-]{4,29}$")
    private String name;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z][A-Za-z-]{4,29}$")
    private String surname;
    @Pattern(regexp = "^[A-Za-z][A-Za-z-]{4,29}$")
    private String patronymic;
}
