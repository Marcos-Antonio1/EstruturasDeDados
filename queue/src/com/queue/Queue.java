package com.queue;

public class Queue<T> {

    private Node<T> refNodeInput; // referência para a entrada ou fim da fila

    public Queue() {
        this.refNodeInput = null;
    }

    public void enqueue(Node<T> newNode) {
        newNode.setRefNode(refNodeInput);
        refNodeInput = newNode;
    }

    public Node<T> dequeue() {
        if (!this.isEmpty()) {
            Node firstNode = refNodeInput;
            Node secondNode = refNodeInput;
            while (true) {
                if (firstNode.getRefNode() != null) {
                    secondNode = firstNode;
                    firstNode = firstNode.getRefNode();
                } else {
                    secondNode.setRefNode(null);
                    break;
                }
            }
            return firstNode;
        }
        return  null;
    }



    public Node<T> first(){
        Node firstNode = null;
        if(!this.isEmpty()){
            Node currentNode = refNodeInput;
            while (true){
               if(currentNode.getRefNode() != null){
                   currentNode = currentNode.getRefNode();
               }else{
                   firstNode=currentNode;
                   break;
               }
            }
        }
        return firstNode;
    }
    public boolean isEmpty(){
        return refNodeInput == null ? true : false;
    }

    @Override
    public String toString() {
        String stringReturn = "";
        Node Nodeaux =  refNodeInput;
        if(refNodeInput != null){
            while (true){
                stringReturn += "[Node{object="+Nodeaux.getObject() +"}] ---->";
                if(Nodeaux.getRefNode() != null){
                    Nodeaux =Nodeaux.getRefNode();
                }else{
                     break;
                 }
            }
        }else{
            stringReturn ="null";
        }
        return  stringReturn;
    }
}
