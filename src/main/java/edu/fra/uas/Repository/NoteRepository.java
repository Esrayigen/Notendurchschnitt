package edu.fra.uas.Repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import edu.fra.uas.Model.Note;

@Repository
public class NoteRepository extends HashMap<Long,Note> {

}
