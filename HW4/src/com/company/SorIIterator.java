package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SorIIterator<T> implements Iterator {
    private double rand;
    private Iterator<T> iter;

    public SorIIterator(Iterator<T> iter){
        this.iter = iter;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public String next() {
        if(!hasNext())
            throw new NoSuchElementException();
        rand = Math.random();
        if (rand < 0.5){
            return next();
        }
        iter.next();
        return "Stop";

    }
}
