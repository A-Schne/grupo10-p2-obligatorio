package Entities;

import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;

public class User {
    private String name;
    private int numberOfTweets;
    private int totalNumOfFavs;
    private boolean isVerified;

    public User(String name) {
        this.name = name;
        this.numberOfTweets = 0;
        this.isVerified = false;
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

    public int getTotalNumOfFavs() {
        return totalNumOfFavs;
    }
    public void setTotalNumOfFavs(int totalNumOfFavs) {
        this.totalNumOfFavs = totalNumOfFavs;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}
