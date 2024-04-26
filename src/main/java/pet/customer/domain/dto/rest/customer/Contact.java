package pet.customer.domain.dto.rest.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import pet.customer.domain.dto.rest.enumeration.ContactType;

import java.util.UUID;

@Data
public class Contact {
    @Null
    private UUID id;
    @NotNull
    private ContactType type;
    @NotBlank
    private String value;
}
