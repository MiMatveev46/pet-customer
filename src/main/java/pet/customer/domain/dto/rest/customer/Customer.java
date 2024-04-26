package pet.customer.domain.dto.rest.customer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Customer {
    private UUID id;
    @Valid
    @NotNull
    private AuthInfo authInfo;
    @Valid
    @NotNull
    private PersonInfo personInfo;
    @Valid
    @NotNull
    @Size(min = 1, max = 5)
    private List<Contact> contacts;
}
