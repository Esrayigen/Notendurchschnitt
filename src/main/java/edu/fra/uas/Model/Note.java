package edu.fra.uas.Model;

import java.io.Serializable;

import org.slf4j.*;

public class Note implements Serializable {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Note.class);
    private long id;
    private String fach;
    private int note;

    public Note() {
        log.debug("User created without values");
    }
    public Note(long id, String fach, int note) {
        log.debug("Note created with values + id: " + id + " fach: " + fach + " note: " + note );
        this.id = id;
        this.fach = fach;
        this.note = note;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    public String getFach(){
        return fach;
    }
    public void setFach(String fach){
        this.fach=fach;
    }
    public int getNote(){
        return note;
    }
    public void setNote(int note){
        this.note=note;
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null) 
            return false;
        if (object == this) 
            return true;
        if (this.getClass() != object.getClass()) 
            return false;
        if (this.fach == null) {
            if (((Note)object).fach != null) 
                return false;
        } else if (!this.fach.equals(((Note)object).fach)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.fach != null ? this.fach.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "User ["+"id=" + id + " fach=" + fach + ", note=" + note+ "]";
    }
}
