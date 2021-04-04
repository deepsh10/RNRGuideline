package com.deepdev.RNRGuideline.repository;

import com.deepdev.RNRGuideline.models.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Notes, String> {

    Notes findByNoteId(String notesId);

    void deleteByNoteId(String notesId);

    List<Notes> findByGoalId(String goalId);
}
