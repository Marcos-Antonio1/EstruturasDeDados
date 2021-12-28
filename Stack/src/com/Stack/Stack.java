package com.Stack;

public class Stack {

    private Node top;


    public Stack() {
        this.top= null;
    }

    public void push(Node newNode){
        Node aux = top;
        this.top = newNode;
        top.setNextNode(aux);
    }

    public Node pop(){
        if(!this.isEmpty()){
            Node noPoped =top;
            top = top.getNextNode();
            return noPoped;
        }
        return null;
    }

    public Node top(){
        return top;
    }

    public Boolean isEmpty(){
           if(top == null){
               return true;
           }
           return false;
    }

    @Override
    public String toString(){
        String stringReturn = "----------\n";
        stringReturn += "      Pilha\n";
        stringReturn += "---------------\n";

        Node aux = top;

        while(true){
            if(aux != null){
                stringReturn +="[No(dado="+aux.getDado()+")]\n";
                aux= aux.getNextNode();
            }else{
                break;
            }
        }
        stringReturn += "===========\n";
        return stringReturn;
    }

}
