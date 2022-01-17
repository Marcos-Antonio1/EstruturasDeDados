package com.linkedList;

public class LinkedList<T> {

    Node<T> inputReference;

    public  LinkedList(){
        this.inputReference= null;
    }
    public boolean isEmpty(){
        return inputReference == null ? true : false;
    }

    public void add(T content){
        Node<T> newNode = new Node<>(content);

        if(this.isEmpty()){
            inputReference = newNode;
            return;
        }

        Node <T> NodeAux =inputReference;

        for(int i = 0;i<this.size()-1;i++){
            NodeAux= NodeAux.getNextNode();
        }

        NodeAux.setNextNode(newNode);
    }

    public T get(int index){
        return getNode(index).getContent();
    }

    public T remove(int index){
        Node<T> NodePivot =this.getNode(index);
        if(index == 0){
            inputReference = NodePivot.getNextNode();
            return NodePivot.getContent();
        }
        Node <T> NodePrevious = getNode(index-1);
        NodePrevious.setNextNode(NodePivot.getNextNode());
        return  NodePivot.getContent();
    }

    private  Node<T> getNode(int index){

        validateIndex(index);

        Node<T> NodeAux= inputReference;
        Node<T> NodeReturn =null;

        for(int i = 0;i<=index;i++){

            NodeReturn = NodeAux;
            NodeAux= NodeAux.getNextNode();

        }
        return NodeReturn;
    }

    public int size(){
        int listSize = 0;

        Node <T> referenceAux = inputReference;
        while (true){
            if(referenceAux != null){
                listSize++;
                if(referenceAux.getNextNode() != null){
                    referenceAux = referenceAux.getNextNode();
                }else {
                    break;
                }
            }else{
                break;
            }
        }

        return listSize;
    }
    private void validateIndex(int index ){
        if(index >= size()){
            throw  new IndexOutOfBoundsException("There is no content in the index " + index + "this list");
        }
    }

    @Override
    public String toString() {

        String strReturn ="";
        Node <T> NodeAux =inputReference;

        for(int i= 0;i<this.size();i++){
            strReturn += "Node{ content= "+NodeAux.getContent() + "} --->";
            NodeAux = NodeAux.getNextNode();
        }
        strReturn += "null";

        return  strReturn;
    }
}
