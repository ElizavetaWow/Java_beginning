package com.company;

public class Ball extends SolidOfRevolution{

    public Ball(double radius) {
        super(radius);
    }

    @Override
    public double getVolume() {
        return 4/3 * Math.PI * Math.pow(radius, 3);
    }


}
