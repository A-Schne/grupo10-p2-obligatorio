package Entities;

import CSVResources.CSVTweetReader;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;

public class Tweet implements CSVTweetReader {
    private long id;
    private String content;
    private String source;
    private boolean isRetweet;
    private LinkedList<Hashtag> hashtags;
    private User user;

    public Tweet(long id, String content, String source, boolean isRetweet, LinkedList<Hashtag> hashtags, User user) {
        this.id = id;
        this.content = content;
        this.source = source;
        this.isRetweet = isRetweet;
        this.hashtags = new LinkedList<>();
        this.user = user;
    }

    @Override
    public void execute(CSVRecord record) {
    }
}
