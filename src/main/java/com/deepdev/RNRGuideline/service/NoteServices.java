package com.deepdev.RNRGuideline.service;

import com.deepdev.RNRGuideline.exception.RNRAppException;
import com.deepdev.RNRGuideline.models.Notes;
import com.deepdev.RNRGuideline.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class NoteServices {

    @Autowired
    private NoteRepository NotesRepository;

    public void addNotes(Notes notes) {
        System.out.println("Adding Notes ");
        notes.setNoteCreationDate(Instant.now());
        NotesRepository.save(notes);
    }

    public List<Notes> getNotes() {

        return NotesRepository.findAll();

    }

    public Notes updateNotes(String NotesId, Notes updateNotes) {

        Notes Notes = NotesRepository.findByNoteId(NotesId);

        if(Notes == null){
            throw new RNRAppException("Invalid Input. Incorrect input provided.");
        }

        Notes.setNoteText(updateNotes.getNoteText());

        Notes returnNotes = NotesRepository.save(Notes);

        return returnNotes;
    }

    public HttpStatus deleteNotes(String NotesId) {

        Notes Notes = NotesRepository.findByNoteId(NotesId);

        if(Notes == null){
            throw new RNRAppException("Invalid Input. Incorrect input provided.");
        }

        NotesRepository.deleteByNoteId(NotesId);
        return HttpStatus.ACCEPTED;
    }

    public List<Notes> getNotesByGoalId(String goalId) {

        List<Notes> notesList = NotesRepository.findByGoalId(goalId);

        return  notesList;

    }
}
