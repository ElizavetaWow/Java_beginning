package com.company;

import java.util.ArrayList;
import java.util.Collection;

public class Vectr {
    private  int x, y, z;
    public Vectr(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void printVectr() {
        System.out.println(x+" "+y+" "+z);
    }
    public double lenVec() {
        double res;
        res = Math.sqrt(x*x+y*y+z*z);
        return res;
    }
    public int scalVec(Vectr other) {
        int res = x*other.x+y*other.y+z*other.z;
        return res;
    }
    public Vectr mulVec(Vectr other) {
        Vectr res = new Vectr(y*other.z-z*other.y,z*other.x-x*other.z, x*other.y-y* other.x);
        return res;
    }
    public double angVec(Vectr other) {
        double res;
        res = this.scalVec(other)/(lenVec()*other.lenVec());
        return res;
    }
    public Vectr sumVec(Vectr other) {
        Vectr res = new Vectr(x+other.x,y+other.y, z+other.z);
        return res;
    }
    public Vectr difVec(Vectr other) {
        Vectr res = new Vectr(x-other.x,y-other.y, z-other.z);
        return res;
    }
    public static Vectr[] randVec(int n) {
        Vectr[] res = new Vectr[n];
        for (int i = 0; i < n; i++){
            res[i] = new Vectr((int) (Math.random()*50-20), (int) (Math.random()*50-20), (int) (Math.random()*50-20));
        }
        return res;
    }
}
