package com.doublyLinkedList;

public class Main {

    public static void main(String[] args) {

        DoubleLinkedList<String> doubleLinkedList= new DoubleLinkedList<>();

        doubleLinkedList.add("M");
        doubleLinkedList.add("A");
        doubleLinkedList.add("P");
        doubleLinkedList.add("S");

        System.out.println(doubleLinkedList);

        doubleLinkedList.add(2,"L");

        System.out.println(doubleLinkedList);
        System.out.println(doubleLinkedList.size());

        doubleLinkedList.add("W");

        System.out.println(doubleLinkedList);
        System.out.println(doubleLinkedList.size());

        doubleLinkedList.remove(5);
        System.out.println(doubleLinkedList);
        System.out.println(doubleLinkedList.size());

    }
}
