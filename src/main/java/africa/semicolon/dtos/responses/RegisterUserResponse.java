package africa.semicolon.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserResponse {
    private String id;
    private String message;
    private String email;
}
