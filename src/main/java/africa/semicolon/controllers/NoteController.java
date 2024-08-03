package africa.semicolon.controllers;

import africa.semicolon.dtos.requests.AddNoteRequest;
import africa.semicolon.dtos.requests.UpdateNoteRequest;
import africa.semicolon.dtos.responses.AddNoteResponse;
import africa.semicolon.dtos.responses.DeleteNoteResponse;
import africa.semicolon.dtos.responses.ApiResponse;
import africa.semicolon.dtos.responses.UpdateNoteResponse;
import africa.semicolon.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/notes")
@AllArgsConstructor
public class NoteController {
    private NoteService noteService;

    @PostMapping("/add-note")
    public ResponseEntity<?> addNote(@RequestBody AddNoteRequest request){
        try{
            AddNoteResponse response = noteService.createNoteWith(request);
            return new ResponseEntity<>(new ApiResponse(true,response), CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception),BAD_REQUEST);
        }
    }
    @PatchMapping("/update-note")
    public ResponseEntity<?> updateNote(@RequestBody UpdateNoteRequest request){
        try{
            UpdateNoteResponse response = noteService.updateNoteWith(request);
            return new ResponseEntity<>(new ApiResponse(true,response), OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception),BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete-note{id}")
    public ResponseEntity<?> deleteNote(@PathVariable("id") String id){
        try{
            DeleteNoteResponse response = noteService.deleteNote(id);
            return new ResponseEntity<>(new ApiResponse(true,response), OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }
}
