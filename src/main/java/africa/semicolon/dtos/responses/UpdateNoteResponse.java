package africa.semicolon.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class UpdateNoteResponse {
    private String noteId;
    private String updatedTitle;
    private String updatedContent;
    private LocalDateTime dateUpdated;
}
