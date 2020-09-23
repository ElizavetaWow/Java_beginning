package com.company;

public class Cylinder extends SolidOfRevolution {
    private double height;

    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return height * Math.PI * Math.pow(radius, 2);
    }
}
