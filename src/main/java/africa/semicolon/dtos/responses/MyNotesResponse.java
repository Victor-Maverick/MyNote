package africa.semicolon.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MyNotesResponse {
    private boolean isSuccessful;
    private Object data;
}
