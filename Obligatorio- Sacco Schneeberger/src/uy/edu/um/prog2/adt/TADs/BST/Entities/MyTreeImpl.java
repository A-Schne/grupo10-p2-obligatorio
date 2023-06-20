package uy.edu.um.prog2.adt.TADs.BST.Entities;

import java.util.ArrayList;
import java.util.List;

public class MyTreeImpl<K extends Comparable<K>, T> implements MyTreeInt<K, T>{

    private Nodo<K, T> root;
    private int tamanio;

    public Nodo<K, T> getRoot() {
        return root;
    }

    public void setRoot(Nodo<K, T> root) {
        this.root = root;
    }

    public MyTreeImpl() {
        this.root = null;
        this.tamanio = 0;
    }

    @Override
    public T find(K key) {
        if (root==null){
            return null;
        }
        Nodo<K, T> temp = new Nodo<K, T>(key, null);
        return root.search(temp);
    }

    @Override
    public void insert(K key, T data) {
        Nodo nuevoNodo = new Nodo(key, data);
        if (root == null) {
            root = nuevoNodo;
        } else {
            root.add(key, data);
        }
        tamanio++;
    }

    @Override
    public void delete(K key) {
        Nodo<K,T> temp = new Nodo<>(key, null);
        Nodo<K,T> nodo = root.getNodo(temp);
        if(nodo.getLeftChild()==null && nodo.getLeftChild()==null){
            Nodo<K,T> padre = getPadre(root, nodo);
            if(padre.compareTo(nodo)>0){
                padre.setLeftChild(null);
            }
            else{
                padre.setRightChild(null);
            }
            tamanio--;
        }

        //Si tiene hijo por la izquierda y no en la derecha
        if(nodo.getLeftChild() != null && nodo.getRightChild() == null){
            Nodo<K,T> padre = getPadre(root, nodo);
            if(padre.compareTo(nodo)>0){
                padre.setLeftChild(nodo.getLeftChild());
            }
            else{
                padre.setRightChild(nodo.getLeftChild());
            }
            tamanio--;
        }

        //Si tiene hijo por la derecha y no la izquierda
        if(nodo.getLeftChild() == null && nodo.getRightChild() != null){
            Nodo<K,T> padre = getPadre(root, nodo);
            if(padre.compareTo(nodo)>0){
                padre.setLeftChild(nodo.getRightChild());
            }
            else{
                padre.setRightChild(nodo.getRightChild());
            }
            tamanio--;
        }

        //Si tiene 2 hijos, por conveniencia suplanto al nodo con su hijo derecho

        if(nodo.getLeftChild()!=null && nodo.getRightChild()!=null){
            Nodo<K,T> padre = getPadre(root, nodo);
            if(padre.compareTo(nodo)>0){
                Nodo<K,T> nodoDerecho = nodo.getRightChild();
                padre.setLeftChild(nodoDerecho);
                nodoDerecho.setLeftChild(nodo.getLeftChild());


            }
            else{
                Nodo<K,T> nodoDerecho = nodo.getRightChild();
                padre.setRightChild(nodoDerecho);
                nodoDerecho.setLeftChild(nodo.getLeftChild());

            }
            tamanio--;
        }
        //si tiene dos hijos, hacer un setchild del padre del nodo con el hijo del nodo
        //ejemplo, si tengo 2 3 4 5 6, y remuevo el 3, hacer un 5.setleftchild(4) y 4.setleftchild(2). de esta manera se saca al 3
    }

    public Nodo<K,T> getPadre(Nodo<K,T> current,Nodo<K,T> nodoHijo){
        if(current.getLeftChild().compareTo(nodoHijo) == 0 || current.getRightChild().compareTo(nodoHijo) == 0){
            return current;
        }
        if(current.compareTo(nodoHijo) > 0){
            current = current.getLeftChild();
            return(getPadre(current, nodoHijo));
        }
        if(current.compareTo(nodoHijo) < 0){
            current = current.getRightChild();
            return(getPadre(current, nodoHijo));
        }
        return null;
    }

    public int size(){
        return tamanio;
    }

    public int countLeaf() {
        return root.countHojas();
    }

    public int countComplete(){
        return root.countComplete();
    }

    public List preOrder(){
        List lista = new ArrayList();
        root.hacerPreOrder(lista);
        return lista;
    }

    public List postOrder(){
        List lista = new ArrayList();
        root.hacerPostOrder(lista);
        return lista;
    }

    public List inOrder(){
        List lista = new ArrayList();
        root.hacerInOrder(lista);
        return lista;
    }
}
