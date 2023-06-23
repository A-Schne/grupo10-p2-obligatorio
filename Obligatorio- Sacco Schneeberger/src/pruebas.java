import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.Lista;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class pruebas {
    public static void main(String[] args) throws FileNotFoundException {

        int[] prueba = new int[2];

        String nombrePiloto = "Agustin Van Schneeberger";

        String[] partesDeNombre = nombrePiloto.split("\\s");

        String nombre = null;
        String apellido = null;

        if(partesDeNombre.length == 2){
            nombre = partesDeNombre[0];
            apellido = partesDeNombre[1];
        }

        if(partesDeNombre.length == 3){
            nombre = partesDeNombre[0];
            apellido = partesDeNombre[1]+" "+partesDeNombre[2];
        }

        System.out.println(nombre);
        System.out.println(apellido);
    }
}
