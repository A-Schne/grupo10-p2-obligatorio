package Consultas;

import CSVResources.CSVTweetReader;
import Entities.User;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.TADs.BST.Entities.MyTreeImpl;
import uy.edu.um.prog2.adt.TADs.BST.Entities.MyTreeInt;
import uy.edu.um.prog2.adt.TADs.BST.Entities.Nodo;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHash;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHashImpl;
import uy.edu.um.prog2.adt.TADs.Hash.Exceptions.ErrorEncontrado;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;
import uy.edu.um.prog2.adt.TADs.Linked_List.Exceptions.NoExiste;

public class ConsultaMostTweetsUser implements CSVTweetReader {

    private MyHash<String, User> users;
    private LinkedList<String> usernames;
    private MyTreeInt<Integer, User> usersTree;
    private LinkedList<User> userFinal;
    private MyHash<Integer, Integer> valores;
    public ConsultaMostTweetsUser() {
        this.users = new MyHashImpl<>(600000);
        this.usernames = new LinkedList<>();
        this.usersTree = new MyTreeImpl<>();
        this.userFinal = new LinkedList<>();
        this.valores = new MyHashImpl<>(600000);
    }
    @Override
    public void execute(CSVRecord record) throws Exception {

        String user_name = record.get("user_name");
        String isVerified = record.get("user_verified").toLowerCase();
        boolean isVerifiedBool = Boolean.parseBoolean(isVerified);
        if(users.contains(user_name)){
            User tempUser = users.findObject(user_name);
            tempUser.setNumberOfTweets(tempUser.getNumberOfTweets()+1);
        }else{
            User nuevoUser = new User(user_name);
            if(isVerifiedBool)
                nuevoUser.setVerified(true);
            usernames.add(user_name);
            users.put(user_name, nuevoUser);
            nuevoUser.setNumberOfTweets(1);
        }
    }


    public void orderUsers() throws NoExiste, ErrorEncontrado {
        User dummyUser = new User("prueba");
        usersTree.insert(1, dummyUser);
        valores.put(0, 0);
        for(int i=0; i< usernames.size(); i++){
            User tempUser = users.findObject(usernames.get(i));             //Para usar el CSV test, se eliminan las lineas 54 a 58
            if(!(valores.contains(tempUser.getNumberOfTweets()))){
                usersTree.insert(tempUser.getNumberOfTweets(), tempUser);
                valores.put(tempUser.getNumberOfTweets(), 1);
            }
            //usersTree.insert(tempUser.getNumberOfTweets(), tempUser);     En caso de eliminar las lineas anteriores, descomentar esto
        }
        for(int i=0; i<usernames.size(); i++){
            getMostTweets(usersTree.getRoot());
        }
    }


    public void getMostTweets(Nodo<Integer, User> nodoUser){
        if(nodoUser.getRightChild()!=null){
            getMostTweets(nodoUser.getRightChild());
        }
        else{
            userFinal.add(nodoUser.getData());
            usersTree.delete(nodoUser.getKey());
        }
    }

    public void hacerSegundaConsulta() throws NoExiste, ErrorEncontrado {
        orderUsers();
        System.out.println("Los usuarios con mas tweets son: ");
        for(int i=0; i<15; i++){
            if(userFinal.get(i).isVerified())
                System.out.println((i+1) + ". " + userFinal.get(i).getName() + "(\u2713)" + " con " + userFinal.get(i).getNumberOfTweets() + " tweets.");
            else{
                System.out.println((i+1) + ". " + userFinal.get(i).getName() + " con " + userFinal.get(i).getNumberOfTweets() + " tweets.");
            }
        }
    }
}



