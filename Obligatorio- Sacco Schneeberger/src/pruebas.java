import Entities.User;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHash;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHashImpl;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Lista;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class pruebas {
    public static void main(String[] args) throws FileNotFoundException {

        MyHash<String, User> userPrueba = new MyHashImpl<>();

        userPrueba.setTableSize(10);

        User user = new User("Hola");

        userPrueba.put("Hola", user);
        System.out.println(userPrueba.containsKey("BLa"));

    }
}
