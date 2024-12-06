package edu.fra.uas.Config;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.Model.Note;
import edu.fra.uas.Service.NoteService;
import jakarta.annotation.PostConstruct;

@Component
public class InitData {
    
        private final Logger log = org.slf4j.LoggerFactory.getLogger(InitData.class);
        @Autowired
        NoteService noteService;
    
        @PostConstruct
        public void init() {
            log.debug("### Initialize Data ###");
    
            log.debug("create Mathenote"); 
            Note matheNote = new Note(); 
            matheNote.setFach("Mathe");
            matheNote.setNote(2); 
    
            noteService.createNote(matheNote); 
    
            log.debug("create Englsichnote");
            Note englischNote = new Note();
    
            englischNote.setFach("Englisch");
            englischNote.setNote(3);
    
            noteService.createNote(englischNote);
    
            log.debug("create Sportnote");
            Note sportNote = new Note();
    
            sportNote.setFach("Sport");
            sportNote.setNote(1);
    
            noteService.createNote(sportNote);

    
            log.debug("### Data initialized ###");
        }
    
    }
