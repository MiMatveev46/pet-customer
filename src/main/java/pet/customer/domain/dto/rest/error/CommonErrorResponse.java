package pet.customer.domain.dto.rest.error;

import lombok.Builder;
import lombok.Data;
import pet.customer.domain.dto.rest.enumeration.ErrorType;

import java.time.LocalDateTime;

@Data
@Builder
public class CommonErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private ErrorType type;
    private Object cause;
}
