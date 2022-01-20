package com.circularList;

public class CircularList<T> {

    private Node<T> head;
    private Node<T> tail;
    private  int sizeList;

    public CircularList(){
        this.head =null;
        this.tail = null;
        this.sizeList =0;
    }

    public int size(){
       return this.sizeList;
    }

    public boolean  isEmpty(){
        return  this.sizeList == 0 ?  true :false;
    }

    private Node<T> getNode(int index){
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("the is Empty");
        if(index == 0){
            return this.tail;
        }
        Node<T> auxNode = this.tail;
        for(int i =0 ;i<index;i++){
            auxNode = auxNode.getNextNode();
        }

        return auxNode;
    }

    public T get(int index){
        return  this.getNode(index).getContent();
    }

    public void remove(int index){
        if(index >= size()){
            throw  new IndexOutOfBoundsException("Index Invalid");
        }
        Node<T> auxNode = this.tail;

        if(index == 0){
            this.tail = this.tail.getNextNode();
            this.head.setNextNode(this.tail);
        }else if(index == 1){
            this.tail.setNextNode(this.tail.getNextNode());
        }else{
            for(int i =0; i< index -1;i++){
                auxNode = auxNode.getNextNode();
            }
            auxNode.setNextNode(auxNode.getNextNode().getNextNode());
        }
        this.sizeList--;
    }

    public void add(T content){
        Node<T> newNode = new Node<>(content);
        if(isEmpty()){
            this.head =newNode;
            this.tail = this.head;
            this.head.setNextNode(tail);
        }else{
            newNode.setNextNode(this.tail);
            this.head.setNextNode(newNode);
            this.tail = newNode;
        }
        this.sizeList++;
    }

    @Override
    public String toString() {
        String str = "";

        Node<T> auxNode = this.tail;
        for(int i=0; i<size();i++){
            str += "[Node{content ="+auxNode.getContent() +"}] --->";
            auxNode = auxNode.getNextNode();
        }
        str += this.size() != 0 ?"[Node{content ="+tail.getContent() +"}]": "[]";
        return  str;
    }
}
