package com.company;

public class Pyramid extends Shape{
    private double s, h;
    public Pyramid(double s, double h) {
        this.h = h;
        this.s = s;
    }

    @Override
    public double getVolume() {
        return 1/3 * s * h;
    }

}
