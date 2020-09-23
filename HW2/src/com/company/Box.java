package com.company;

import java.util.ArrayList;

public class Box extends Shape{
    private double size, space;
    private ArrayList<Shape> shapes = new ArrayList<>();
    public Box(double size){
        this.size = size;
        this.space = size;
    }
    public boolean add(Shape sh){
        if (sh.getVolume() <= space){
            space -= sh.getVolume();
            shapes.add(sh);
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public double getVolume() {
        return size;
    }
}
