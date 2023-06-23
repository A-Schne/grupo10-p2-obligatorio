package Entities;

import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;

public class Hashtag {
    private long id;
    private String text;
    private int numTwitted;

    public Hashtag(String text) {
        this.text = text;
        this.numTwitted = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumTwitted() {
        return numTwitted;
    }

    public void setNumTwitted(int numTwitted) {
        this.numTwitted = numTwitted;
    }
}
