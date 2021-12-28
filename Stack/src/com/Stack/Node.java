package com.Stack;

public class Node {

    private int dado;
    private Node nextNode;

    public Node(int dado) {
        this.nextNode= null;
        this.dado = dado;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "dado=" + dado +
                '}';
    }
}
