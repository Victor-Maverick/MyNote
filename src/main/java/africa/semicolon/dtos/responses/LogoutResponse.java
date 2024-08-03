package africa.semicolon.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogoutResponse {
    private String message;
    private boolean isLoggedIn;
}
