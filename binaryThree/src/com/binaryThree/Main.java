package com.binaryThree;

import com.binaryThree.model.Obj;

public class Main {

    public static void main(String[] args) {

        BinaryThree three = new BinaryThree<>();

        // root
        three.insert(new Obj(5));
        // subthree right
        three.insert(new Obj(7));
        three.insert( new Obj(6));
        three.insert( new Obj(8));
        // subThree left
        three.insert( new Obj(3));
        three.insert( new Obj(2));
        three.insert( new Obj(4));

        three.preOrder();
        three.inOrder();
        three.posOrder();
        

        three.preOrder();
        three.inOrder();
        three.posOrder();
    }
}
