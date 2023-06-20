package uy.edu.um.prog2.adt.TADs.Linked_List.Test;
import uy.edu.um.prog2.adt.TADs.Linked_List.Entities.LinkedList;
import uy.edu.um.prog2.adt.TADs.Linked_List.Exceptions.NoExiste;
import org.junit.Test;

public class TestUnitario {
    LinkedList<Integer> lista = new LinkedList<>();

    @Test
    public void sizeVacioTest(){
        lista.size(); //Aun no se creo la lista, devuelve una exception
    }

    @Test
    public void addTest(){
        lista.add(1); //Primera en agregarse
        lista.add(-1);
        lista.add(13);
        lista.add(987);
        lista.add(-11);
        lista.add(-9876);
    }

    @Test
    public void removeTest() throws NoExiste {
        try {
            lista.remove(8);  //8 no tiene ningun nodo, el tamaño de la lista es 6
            lista.remove(-1); //Posicion -1 no existe
            lista.remove(0); //Saca elemento de valor 1
            lista.remove(5); //No hay nada en posicion 5, la lista disminuyo de tamaño (Tamaño 5)
        }
        catch (NoExiste NE){
            //Ignora exception
        }
    }

    @Test
    public void sizeTest() throws Exception {
        lista.size(); //Deberia devolver 4
    }

    @Test
    public void getTest() throws NoExiste {
        try {
            lista.get(0);
            lista.get(3);
            lista.get(10); //Throws NoExiste porque esta fuera de la lista
        }
        catch(NoExiste E){
            //Ignora la exception
        }
    }
}

