package africa.semicolon.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddNoteRequest {
    private String title;
    private String content;
}
