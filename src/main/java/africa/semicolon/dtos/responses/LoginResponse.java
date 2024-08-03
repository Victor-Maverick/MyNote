package africa.semicolon.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {
    private String email;
    private String message;
    private boolean isLoggedIn;
}
