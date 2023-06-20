package Entities;

import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;

public class Tweet {
    private long id;
    private String content;
    private String source;
    private boolean isRetweet;
    private LinkedList<Hashtag> hashtags;
    private User user;
}
