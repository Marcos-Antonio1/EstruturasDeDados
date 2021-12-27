package com.Node;

public class Main {

    public static void main(String[] args) {

        Node<String> node1 = new Node<String>("this is node 1");

        Node<String> node2 = new Node<String>("this is node 2");
        node1.setNextNode(node2);

        Node<String> node3 = new Node<String>("this is node 3");
        node2.setNextNode(node3);

        Node<String> node4 = new Node<String>("this is node4");
        node3.setNextNode(node4);

        //node1->node2 ->node3->node4

        System.out.print(node1);
        System.out.print(node1.getNextNode());
        System.out.print(node1.getNextNode().getNextNode());
    }
}
