package com.spring.noteapp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class Note {
    public long id;
    public String title;
    public String content;
    private static final AtomicLong idCounter = new AtomicLong(0);

    public Note(long id, String title, String content) {
        this.title = title;
        this.content = content;
        this.id = id;
    }

    public long getId() {
        return id;
    }

/*    private static long generateId(){
        return idCounter.addAndGet(1);
    }*/
}
