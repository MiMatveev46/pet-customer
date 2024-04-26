package pet.customer.domain.dto.rest.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AuthInfo {
    @NotBlank
    @Pattern(regexp = "^[A-Za-z][A-Za-z_-]{4,29}$")
    private String login;
    @NotBlank
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z_0-9-]{5,30}$")
    private String password;
}
