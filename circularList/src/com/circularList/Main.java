    package com.circularList;

public class Main {

    public static void main(String[] args) {
	    CircularList<String> list = new CircularList<>();
        System.out.println(list);

        list.add("C");
        list.add("R");
        list.add("A");
        list.add("M");

        System.out.println(list);

        System.out.println(list.get(2));

        list.remove(2);

        System.out.println(list);

    }
}
