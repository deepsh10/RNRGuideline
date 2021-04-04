package com.deepdev.RNRGuideline.controller;

import com.deepdev.RNRGuideline.models.Notes;

import com.deepdev.RNRGuideline.service.NoteServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteServices noteServices;

    @RequestMapping(method= RequestMethod.POST,value= "/add")
    public ResponseEntity addNote(@RequestBody Notes notes)
    {
        noteServices.addNotes(notes);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method= RequestMethod.GET,value= "/get/{goalId}")
    public ResponseEntity getNote(@PathVariable String goalId)
    {
        List<Notes> notesList = noteServices.getNotesByGoalId(goalId);

        return new ResponseEntity(notesList,HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.POST,value= "/update/{noteId}")
    public ResponseEntity updateNote(@PathVariable String noteId,@RequestBody Notes note)
    {
        Notes notes = noteServices.updateNotes(noteId,note);
        return new ResponseEntity(notes,HttpStatus.ACCEPTED);
    }

    @RequestMapping(method= RequestMethod.POST,value= "/delete/{userId}")
    public ResponseEntity deleteNote(@PathVariable String noteId)
    {
        noteServices.deleteNotes(noteId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
