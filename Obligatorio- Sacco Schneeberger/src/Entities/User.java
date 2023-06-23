package Entities;

import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;

public class User {
    private long id;
    private String name;
    private int numberOfTweets;

    public User(String name) {
        this.id = id;
        this.name = name;
        this.numberOfTweets = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfTweets() {
        return numberOfTweets;
    }

    public void setNumberOfTweets(int numberOfTweets) {
        this.numberOfTweets = numberOfTweets;
    }
}
