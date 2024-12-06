package edu.fra.uas.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fra.uas.Model.Note;
import edu.fra.uas.Service.NoteService;

@Controller
public class NoteController {
    private final Logger log = org.slf4j.LoggerFactory.getLogger(NoteController.class);

    @Autowired
    private NoteService noteService;
     // http://127.0.0.1/
    @RequestMapping
	public String get() {
        log.debug("get() is called");
		return "index.html";
	}

    // http://127.0.0.1/list
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String list(Model model) {
        log.debug("list() is called");
        Iterable<Note> noteIter = noteService.getAllUsers();
        List<Note> notenListe= new ArrayList<>();
        for (Note noten : noteIter) {
            notenListe.add(noten);
        }
        model.addAttribute("noten", notenListe);
        return "list.html";
    }
        // http://127.0.0.1/find?id=1
    @RequestMapping(value = {"/find"}, method = RequestMethod.GET)
    public String find(@RequestParam("id") Long noteId, Model model) {
        log.debug("find() is called");
        Note noten = noteService.getNoteById(noteId);
        model.addAttribute("noten", noten);
        return "find.html";
    }
    
    @RequestMapping(value = { "/add" }, method = RequestMethod.GET)
    public String add() {
        log.debug("add() is called");
        return "add.html";
    }
// http://127.0.0.1/add?firstName=Celine&lastName=Clever&email=celine.clever%40example.com&password=123456
    @RequestMapping(value = {"/added"}, method = RequestMethod.GET)
    public String add(@RequestParam("fach") String fach, 
                      @RequestParam("note") int note, 
                      Model model) throws MissingServletRequestParameterException {
        log.debug("add() is called");
        Note noten = new Note();
        noten.setFach("FACH");
        noten.setNote(note);
        noteService.createNote(noten);
        model.addAttribute("noten", noten);
        return "added.html";
    }
    // http://127.0.0.1/update
    @RequestMapping(value = {"/update"}, method = RequestMethod.GET)
    public String update() {
        log.debug("update() is called");
        return "update.html";
    }
     // http://127.0.0.1/updated?id=2&firstName=Alice&lastName=Abraham&email=alice%40example.com&password=123A456
     @RequestMapping(value = {"/updated"}, method = { RequestMethod.GET, RequestMethod.POST })
     public String update(@RequestParam("id") Long noteId, 
                          @RequestParam("Modul") String modul, 
                          @RequestParam("note") int note, 
                          Model model) {
         log.debug("updated() is called");
         Note noten = noteService.getNoteById(noteId);
         noten.setFach(modul);
         noten.setNote(note);
         noteService.updateNote(noten);
         model.addAttribute("note", noten);
         return "updated.html";
     }
        @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long notenid, Model model) {
        log.debug("delete() is called");
        Note note = noteService.getNoteById(notenid);
        noteService.deleteNote(notenid);
        model.addAttribute("note", note);
        return "deleted.html";
    }
}
