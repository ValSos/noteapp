package com.spring.noteapp;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService{
    private static final Map<Long, Note> noteMap = new HashMap<>();
    private static final AtomicLong idCounter = new AtomicLong(0);

    public Note add(Note note) {
        long id = generateId();
        note.setId(id);
        noteMap.put(id,note);
        return note;
    }

    private long generateId(){
        return idCounter.addAndGet(1);
    }

    public Map<Long, Note> listAll(){
        return noteMap;
    }

    public void deleteById(long id) {
        if (noteMap.containsKey(id)) {
            noteMap.remove(id);
        } else {
            throw new IllegalArgumentException("Object with id " + id + " does not exist");
        }
    }

    public void update(Note note){
        if (noteMap.containsKey(note.getId())) {
            note.setTitle(note.getTitle());
            note.setContent(note.getContent());
        }
        else {
            throw new IllegalArgumentException("Object with id " + note.getId() + " does not exist");
        }
    }

    public Note getById(long id) {
        if (noteMap.containsKey(id)){
            return noteMap.get(id);
        }
        else {
            throw new IllegalArgumentException("Object with id " + id + " does not exist");
        }
    }



}
