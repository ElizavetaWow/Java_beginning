package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterIterator<T> implements Iterator {
    private Iterator<T>  it1;
    private Iterator<T>  it2;

    public IterIterator(Iterator<T> it1, Iterator<T> it2){
        this.it1 = it1;
        this.it2 = it2;
    }

    @Override
    public boolean hasNext() {
        return it1.hasNext() & it2.hasNext();
    }

    @Override
    public ArrayList<T> next() {
        if(!hasNext())
            throw new NoSuchElementException();
        ArrayList<T> ar = new ArrayList<T>();
        ar.add(it1.next());
        ar.add(it2.next());
        return ar;
    }
}
