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
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Lista;

import java.util.List;

public class ConsultaUserWithMostFavs implements CSVTweetReader {

    private MyHash<String, User> users;
    private Lista<User> topUsers;
    private Lista<String> usernames;
    private MyTreeInt<Integer, User> favsTree;

    public ConsultaUserWithMostFavs() {
        this.users = new MyHashImpl<>(250000);
        this.topUsers = new LinkedList<>();
        this.usernames = new LinkedList<>();
        this.favsTree = new MyTreeImpl<>();
    }

    @Override
    public void execute(CSVRecord record) throws Exception {


        try {
            String name = record.get("user_name");
            String favsString = record.get("user_favourites").replace(".0", "");


            int favs = Integer.parseInt(favsString);
            if(users.contains(name)){
                User temp = users.findObject(name);
                temp.setTotalNumOfFavs(temp.getTotalNumOfFavs()+favs);
            }
            else{
                User newUser = new User(name);
                newUser.setTotalNumOfFavs(favs);
                users.put(name, newUser);
                usernames.add(name);
            }
        }

        catch (NumberFormatException NFE){
        }
    }

    public void orderByFavs() throws Exception {
        User dummyUser = new User("Prueba");
        favsTree.insert(1, dummyUser);
        for(int i=0; i<usernames.size(); i++){
            User user = users.findObject(usernames.get(i));
            favsTree.insert(user.getTotalNumOfFavs(), user);
        }

        for(int j=0; j<=7; j++){
            getMostFav(favsTree.getRoot());
        }

    }

    public void getMostFav(Nodo<Integer, User> userNodo){
        if(userNodo.getRightChild()!=null){
            getMostFav(userNodo.getRightChild());
        }
        else{
            topUsers.add(userNodo.getData());
            favsTree.delete(userNodo.getKey());
        }
    }

    public void hacerQuintaConsulta() throws Exception {
        orderByFavs();
        System.out.println("Top 7 cuentas con mas favs");
        for(int i=0; i< topUsers.size(); i++){
            System.out.println((i+1) + "." + topUsers.get(i).getName() + " con una cantidad de " + topUsers.get(i).getTotalNumOfFavs() + " favoritos.");
        }
    }

}
