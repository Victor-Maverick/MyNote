package africa.semicolon.data.repositories;

import africa.semicolon.data.models.Note;
import africa.semicolon.dtos.requests.AddNoteRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NoteRepositoryTest {
    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void SaveNoteTest(){
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("new title");
        request.setContent("new Content");
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note = noteRepository.save(note);
        assertNotNull(note.getId());
        assertEquals(noteRepository.count(), 1);
    }
}