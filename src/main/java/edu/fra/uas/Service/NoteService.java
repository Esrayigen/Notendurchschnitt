package edu.fra.uas.Service;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fra.uas.Model.Note;
import edu.fra.uas.Repository.NoteRepository;

@Service
public class NoteService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(NoteService.class);
    @Autowired
    private NoteRepository noteRepository;
    private long nextNoteId=1;

    public Note createNote(Note noten) {
        log.debug("createNote: " + noten);
        noten.setId(nextNoteId++);
        noteRepository.put(noten.getId(), noten);
        return noten;
    }
    public Iterable<Note> getAllUsers() {
        log.debug("getAllUsers");
        return noteRepository.values();
    }
    
    public Note getNoteById(long id) {
        log.debug("getNote: " + id);
        return noteRepository.get(id);
    }
    
    public Note updateNote(Note noten) {
        log.debug("updateNote: " + noten);
        noteRepository.put(noten.getId(), noten);
        return noten;
    }

    public void deleteNote(long id) {
        log.debug("deleteNote: " + id);
        noteRepository.remove(id);
    }


}
