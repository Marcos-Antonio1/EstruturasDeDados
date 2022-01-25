package com.binaryThree.model;

public abstract class ObjThree<T> implements  Comparable<T> {

    public abstract  boolean equals(Obj o);
    public  abstract  int hashCode();
    public abstract  int compareTo(T other);
    public  abstract  String toString();

}
