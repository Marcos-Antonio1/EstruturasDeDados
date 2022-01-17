package com.linkedList;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> list= new LinkedList<>();

        // test add Method
        list.add("teste 1");
        list.add("teste 2");
        list.add("teste 3");
        list.add("teste 4");

        System.out.println(list);
        // test isEmpty
        System.out.println("### isEmpty method test ####");
        boolean isEmpty = list.isEmpty();
        System.out.println(isEmpty);

        // test get
        System.out.println("### get method test");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3) + '\n');

        // test size
        System.out.println("### size method test \n");
        System.out.println(list.size()+ '\n');

        // remove method
        System.out.println("### remove method test \n");
        list.remove(3);
        System.out.println(list);






    }
}
