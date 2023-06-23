package Consultas;

import CSVResources.CSVTweetReader;
import Entities.User;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHash;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHashImpl;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;
import uy.edu.um.prog2.adt.TADs.Linked_List.Exceptions.NoExiste;

public class ConsultaMostTweetsUser implements CSVTweetReader {

    private MyHash<String, User> users;
    private LinkedList<String> usernames;
    private int counter;
    public ConsultaMostTweetsUser() {
        this.users = new MyHashImpl<>();
        users.setTableSize(250000);
        this.usernames = new LinkedList<>();
        this.counter = 0;
    }

    @Override
    public void execute(CSVRecord record) throws Exception {

        String user_name = record.get("user_name");
        if(users.containsKey(user_name)){
            User tempUser = users.get(user_name);
            tempUser.setNumberOfTweets(tempUser.getNumberOfTweets()+1);
        }
        else{
            User nuevoUser = new User(user_name);
            usernames.add(user_name);
            users.put(user_name, nuevoUser);
            counter++;
            System.out.println(counter);
            nuevoUser.setNumberOfTweets(nuevoUser.getNumberOfTweets()+1);
        }
    }

    public void prueba() throws NoExiste, uy.edu.um.prog2.adt.TADs.Hash.Exceptions.NoExiste {
        for(int i=0; i< usernames.size(); i++) {
            System.out.println(this.users.get(usernames.get(0)).getNumberOfTweets());
        }
    }
}
