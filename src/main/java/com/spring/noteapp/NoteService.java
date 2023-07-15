package com.spring.noteapp;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService{
    private static final Map<Long, Note> noteMap = new HashMap<>();
    private static final AtomicLong idCounter = new AtomicLong(0);

    static {
        Note note = new Note(1l,"Homework", "Module 13");
        Note note2 = new Note(2l,"Work", "Meeting");
        Note note3 = new Note(3l,"Shopping", "Buy meals");
        noteMap.put(note.getId(), note);
        noteMap.put(note2.getId(), note2);
        noteMap.put(note3.getId(), note3);
    }

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

    public void update(Note note) {
        if (noteMap.containsKey(note.getId())) {
            Note existingNote = noteMap.get(note.getId());
            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());
        } else {
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
