package Entities;

public class Driver {

    private String fullname;
    private String name;
    private String surname;
    private int mentions;

    public Driver(String fullname, String name, String surname) {
        this.fullname = fullname;
        this.name = name;
        this.surname = surname;
        this.mentions = 0;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMentions() {
        return mentions;
    }

    public void setMentions(int mentions) {
        this.mentions = mentions;
    }


}
