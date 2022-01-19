package com.doublyLinkedList;

public class DoubleLinkedList<T> {

    private DoubleNode<T> firstNode;
    private DoubleNode<T> lastNode;

    private int listSize;

    public DoubleLinkedList(){
        this.firstNode= null;
        this.lastNode = null;
        this.listSize=0;
    }

    public int size(){
        return  this.listSize;
    }

    private DoubleNode<T> getNode(int index){
        DoubleNode  auxNode=firstNode;

        for(int i=0;(i<index)&&(auxNode != null);i++){
            auxNode = auxNode.getNextNode();
        }
        return  auxNode;
    }

    public T get(int index){
        return this.getNode(index).getContent();
    }

    public void add (T element){
        DoubleNode<T> newNode =new DoubleNode<>(element);
        newNode.setNextNode(null);
        newNode.setPreviousNode(lastNode);
        if(firstNode == null){
            firstNode = newNode;
        }
        if(lastNode != null){
            lastNode.setNextNode(newNode);
        }

        lastNode= newNode;
        listSize++;
    }

    public void add(int index, T element){
        DoubleNode<T> auxNode = getNode(index);
        DoubleNode<T> newNode = new DoubleNode<>(element);
        newNode.setNextNode(auxNode);

        if(newNode.getNextNode() != null){
            newNode.setPreviousNode(auxNode.getPreviousNode());
            newNode.getNextNode().setPreviousNode(newNode);
        }else{
            newNode.setNextNode(lastNode);
            lastNode = newNode;
        }

        if(index == 0){
            firstNode = newNode;
        }else{
            newNode.getPreviousNode().setNextNode(newNode);
        }

        listSize++;
    }

    public void remove(int index){
        if(index == 0){
            firstNode =firstNode.getNextNode();
            if(firstNode != null){
                firstNode.setPreviousNode(null);
            }
        }else{
            DoubleNode<T> auxNode = getNode(index);
            auxNode.getPreviousNode().setNextNode(auxNode.getNextNode());
            if(auxNode != lastNode){
                auxNode.getNextNode().setPreviousNode(auxNode.getPreviousNode());
            }else{
                lastNode =auxNode;
            }
        }
        this.listSize--;
    }

    @Override
    public String toString() {
        String strReturn = "";

        DoubleNode<T> auxNode = firstNode;

        for(int i =0;i <size();i++){
            strReturn +=  "[Node{content= " + auxNode.getContent() + "}] --->";
            auxNode = auxNode.getNextNode();
        }
        strReturn += "null";

        return  strReturn;
    }
}
