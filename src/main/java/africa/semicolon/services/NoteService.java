package africa.semicolon.services;

import africa.semicolon.dtos.requests.AddNoteRequest;
import africa.semicolon.dtos.requests.UpdateNoteRequest;
import africa.semicolon.dtos.responses.AddNoteResponse;
import africa.semicolon.dtos.responses.DeleteNoteResponse;
import africa.semicolon.dtos.responses.UpdateNoteResponse;

public interface NoteService {
    AddNoteResponse createNoteWith(AddNoteRequest request);
    Long getTotalNotes();
    UpdateNoteResponse updateNoteWith(UpdateNoteRequest request);
    DeleteNoteResponse deleteNote(String noteId);
}
