package com.queue;

public class Main {

    public static void main(String[] args) {
        Queue<People> Fila = new Queue<>();

        Fila.enqueue(new Node(new People("Gabriel",16)));
        Fila.enqueue(new Node(new People("Rikelison",21)));
        Fila.enqueue(new Node(new People("Ana",22)));
        Fila.enqueue(new Node(new People("marcos",25)));
        Fila.enqueue(new Node(new People("Antonio",23)));

        System.out.println("#### Primeiro da Fila ######## \n");
        System.out.println(Fila.first() + "\n");

        System.out.println("#### Fila Completa ######## \n");
        System.out.println(Fila);
        Fila.dequeue();
        Fila.dequeue();
        Fila.dequeue();

        System.out.println("#### Fila Depois do desenfilamento ######## \n" );
        System.out.println(Fila);
        System.out.println("#### Primeiro da Fila ######## \n");
        System.out.println(Fila.first());
    }
}
