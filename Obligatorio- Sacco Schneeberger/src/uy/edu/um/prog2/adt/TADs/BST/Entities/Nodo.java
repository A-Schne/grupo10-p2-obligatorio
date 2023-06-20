package uy.edu.um.prog2.adt.TADs.BST.Entities;

import java.util.List;

public class Nodo<K extends Comparable<K>, T> {
    K key;
    T data;
    Nodo<K, T> leftChild;
    Nodo<K, T> rightChild;

    public Nodo(K key, T data) {
        this.key = key;
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Nodo<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public Nodo<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Nodo<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public int compareTo(Nodo<K, T> obj) {
        return this.key.compareTo(obj.getKey());
    }

    public boolean tieneHijos(){
        if (this.getLeftChild()!=null && this.getRightChild()!=null){
            return true;
        }
        return false;
    }

    public T search(Nodo<K, T> nodo) {
        Nodo<K, T> temp = new Nodo<>(null, null);
        if (this.compareTo(nodo) == 0) {
            temp.setData(this.getData());
        }
        if (this.compareTo(nodo) > 0) {
            return (this.getLeftChild().search(nodo));
        }
        if (this.compareTo(nodo) < 0) {
            return (this.getRightChild().search(nodo));
        }
        return temp.getData();
    }

    public Nodo<K,T> getNodo(Nodo<K, T> nodo) {
        Nodo<K, T> temp = new Nodo<>(null, null);
        if (this.compareTo(nodo) == 0) {
            return this;
        }
        if (this.compareTo(nodo) > 0) {
            return (this.getLeftChild().getNodo(nodo));
        }
        if (this.compareTo(nodo) < 0) {
            return (this.getRightChild().getNodo(nodo));
        }
        return temp;
    }

    public void add(K key, T data) {
        Nodo<K, T> temp = new Nodo<>(key, data);
        if (this.compareTo(temp) == 1) {
            if (this.getLeftChild() == null) {
                this.setLeftChild(temp);
            } else {
                this.getLeftChild().add(key, data);
            }
        }
        if (this.compareTo(temp) <= 0) {
            if (this.getRightChild() == null) {
                this.setRightChild(temp);
            } else {
                this.getRightChild().add(key, data);
            }
        }
    }

    public int countHojas() {
        int count = 0;
        if (this.getLeftChild() == null && this.getRightChild() == null) {
            count++;
        } else {
            count = count + this.getLeftChild().countHojas();
            count = count + this.getRightChild().countHojas();
        }
        return count;
    }

    public int countComplete() {
        int count = 0;
        if (this.getLeftChild()!=null && this.getRightChild()!=null){
            count++;
        }
        if(this.getLeftChild()!=null){
            count = count + this.getLeftChild().countComplete();
        }
        if(this.getRightChild()!=null){
            count = count + this.getRightChild().countComplete();
        }

        return count;
    }

    public List hacerPreOrder(List lista){
        lista.add(this.data);
        if(this.getLeftChild()!=null){
            this.getLeftChild().hacerPreOrder(lista);
        }
        if(this.getRightChild()!=null){
            this.getRightChild().hacerPreOrder(lista);
        }
        return null;
    }

    public List hacerPostOrder(List lista){
        if(this.getLeftChild()!=null){
            this.getLeftChild().hacerPostOrder(lista);
        }
        if(this.getRightChild()!=null){
            this.getRightChild().hacerPostOrder(lista);
        }
        lista.add(this.data);

        return null;
    }

    public List hacerInOrder(List lista){
        if(this.getLeftChild()!=null){
            this.getLeftChild().hacerInOrder(lista);
        }
        lista.add(this.data);

        if(this.getRightChild()!=null){
            this.getRightChild().hacerInOrder(lista);
        }


        return null;
    }
}


