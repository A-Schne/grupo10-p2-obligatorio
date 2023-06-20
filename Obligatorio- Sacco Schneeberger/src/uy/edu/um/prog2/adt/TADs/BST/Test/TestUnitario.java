package uy.edu.um.prog2.adt.TADs.BST.Test;

import uy.edu.um.prog2.adt.TADs.BST.Entities.MyTreeImpl;
import org.junit.Test;

public class TestUnitario {
    MyTreeImpl<Integer, String> bst = new MyTreeImpl<>();

    @Test
    public void testEmptyFind(){
        bst.find(0); //Find a un arbol vacio
    }

    @Test
    public void testInsertAndDelete() {
        bst.insert(10, "*");
        bst.insert(15, "-");
        bst.insert(14, "c");
        bst.insert(16, "d");
        bst.insert(5, "+");
        bst.insert(6, "b");
        bst.insert(4, "a");
        bst.delete(5);
        bst.delete(4);
        try {
            bst.delete(0); //No existe un nodo con key = 0
        }
        catch (NullPointerException NPE){
            //Ignore
        }
        bst.find(6); //Encuentra y devuelve el valor del nodo con key 4
        try {
            bst.find(-5); //No existe nodo con key valor -5
        }
        catch (NullPointerException NPE){
            //Ignore
        }
    }

}
