package africa.semicolon.services;

import africa.semicolon.dtos.requests.AddNoteRequest;
import africa.semicolon.dtos.requests.UpdateNoteRequest;
import africa.semicolon.dtos.responses.AddNoteResponse;
import africa.semicolon.dtos.responses.DeleteNoteResponse;
import africa.semicolon.dtos.responses.UpdateNoteResponse;
import africa.semicolon.exceptions.TitleExistsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NoteServiceTest {
    @Autowired
    private NoteService noteService;

    @Test
    public void addNoteTest(){
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("title");
        request.setContent("content");
        AddNoteResponse response = noteService.createNoteWith(request);
        assertThat(response).isNotNull();
        assertThat(response.getNoteId()).isNotNull();
        assertThat(noteService.getTotalNotes()).isEqualTo(2L);
    }

    @Test
    public void addNoteWithSameTitle_throwsExceptionTest(){
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("title");
        request.setContent("new content");
        assertThrows(TitleExistsException.class, ()->noteService.createNoteWith(request));
    }
    @Test
    public void editNoteTest(){
        UpdateNoteRequest request = new UpdateNoteRequest();
        request.setId("66acc5ee6da84c0dbe65161d");
        request.setNewTitle("updated title");
        request.setNewContent("updated content");
        UpdateNoteResponse response = noteService.updateNoteWith(request);
        assertThat(response.getUpdatedTitle()).contains("updated");
        assertThat(response.getNoteId()).isEqualTo(request.getId());
    }
    @Test
    public void deleteNoteTest(){
        String noteId = "66acc5ee6da84c0dbe65161d";
        DeleteNoteResponse response = noteService.deleteNote(noteId);
        assertThat(response.getMessage()).contains("deleted");
    }

}