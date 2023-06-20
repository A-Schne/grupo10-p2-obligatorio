package uy.edu.um.prog2.adt.TADs.Linked_List.Entities;
import uy.edu.um.prog2.adt.TADs.Linked_List.Exceptions.NoExiste;
public class LinkedList<Tipo> implements Lista<Tipo> {

    private Node first;

    @Override
    public int size() {
        if (first==null){
            return 0;
        }
        int count = 0;
        Node temp = this.first;
        while (temp.getNext() != null){
            temp = temp.getNext();
            count++;
        }
        return count;
    }

    @Override
    public void add(Object value) {
        if (this.first == null){
            this.first = new Node(value);
        }
        else{
            Node temp = this.first;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            Node newNode = new Node(value);
            temp.setNext(newNode);
        }
    }

    @Override
    public void remove(int position) throws NoExiste {
        if (this.first == null){
            throw new NoExiste();
        }
        else{
            Node temp = this.first;
            for (int i = 1; i < position; i++){
                temp = temp.getNext();
            }
            if (position == size()){
                temp.setNext(null);
            }
            else{
                temp.setNext(temp.getNext().getNext());
            }


        }
    }

    @Override
    public Tipo get(int position) throws NoExiste {
        if (this.first == null){
            throw new NoExiste();
        }
        else{
            Node<Tipo> temp = this.first;
            for (int i = 0; i != position; i++) {
                temp = temp.getNext();
            }
            return temp.getValue();

        }
    }

    public boolean estaEnLista(Object value) throws NoExiste {
        if (this.first == null){
            throw new NoExiste();
        }
        else{
            Node temp = this.first;
            while (true){
                if (temp.getValue() == value){
                    return true;
                }
                else{
                    if (temp.getNext() == null){
                        return false;
                    }
                    else {
                        temp = temp.getNext();
                    }
                }
            }
        }
    }

    public void addFirst(Tipo value) {
        Node temp = new Node(value);
        if (this.first == null){
            this.first = temp;
        }
        else{
            temp.setNext(this.first);
            this.first = temp;
        }
    }

    /*public void addLast(Object value){
    }
Esto no es lo mismo que add¿?*/


    public LinkedList() {
        this.first = null;
    }

}
