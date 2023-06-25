package Consultas;

import CSVResources.CSVTweetReader;
import Entities.User;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.TADs.BST.Entities.MyTreeImpl;
import uy.edu.um.prog2.adt.TADs.BST.Entities.MyTreeInt;
import uy.edu.um.prog2.adt.TADs.BST.Entities.Nodo;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHash;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHashImpl;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;
import uy.edu.um.prog2.adt.TADs.Linked_List.Exceptions.NoExiste;

public class ConsultaMostTweetsUser implements CSVTweetReader {

    private MyHash<String, User> users;
    private LinkedList<String> usernames;
    private MyTreeInt<Integer, User> usersTree;
    private LinkedList<User> userFinal;

    public ConsultaMostTweetsUser() {
        this.users = new MyHashImpl<>(250000);
        this.usernames = new LinkedList<>();
        this.usersTree = new MyTreeImpl<>();
        this.userFinal = new LinkedList<>();
    }
}

