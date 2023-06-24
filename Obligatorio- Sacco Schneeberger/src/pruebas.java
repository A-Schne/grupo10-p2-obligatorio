import Entities.User;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHash;
import uy.edu.um.prog2.adt.TADs.Hash.Entities.MyHashImpl;
import uy.edu.um.prog2.adt.TADs.Hash.Exceptions.ErrorEncontrado;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Lista;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class pruebas {
    public static void main(String[] args) throws FileNotFoundException, ErrorEncontrado {

        Scanner scannerFecha = new Scanner(System.in);
        System.out.println("¿En que mes quiere buscar? Escribalo de la forma yyyy-mm");
        String date = scannerFecha.nextLine();

        date = date.substring(0,10);
        System.out.println(date);

    }
}
