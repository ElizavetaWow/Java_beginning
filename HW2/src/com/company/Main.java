package com.company;

public class Main {
    public static void main(String[] args){
        Cylinder c = new Cylinder(5, 3);
        Pyramid p = new Pyramid(50, 10);
        Box box = new Box(500);
        System.out.println(box.add(c));
        System.out.println(box.add(p));
        System.out.println(box.getVolume());
    }
}
