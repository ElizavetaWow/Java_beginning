package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FlatIterator<T> implements Iterator {
    private ArrayList<T> array = new ArrayList<>();
    private int index = 0;

    public FlatIterator(Iterator<T> iter){
        while (iter.hasNext()) {
            this.array.add(iter.next());
        }
    }

    @Override
    public boolean hasNext() {
        return index < array.size();
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        return array.get(index++);
    }
}
