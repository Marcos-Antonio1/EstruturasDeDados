package com.linkedList;

public class Node<T> {

    private T content;
    private Node nextNode;

    public Node() {
        this.nextNode = null;
    }
    public Node(T content){
        this.content =content;
        this.nextNode = null;
    }

    public Node(T content, Node nextNode) {
        this.content = content;
        this.nextNode = nextNode;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        String str= "Node{" + "content=" + content + '}';

        if(nextNode !=null){
            str +=  "->" + nextNode.toString();
        }else{
            str += "-> null";
        }

        return str;
    }
}
