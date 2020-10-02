package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array2DIterator<T> implements Iterator {
    private T[][] array;
    private int indexi = 0;
    private int indexj = 0;

    public Array2DIterator(T[][] array){
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return (indexi < array.length) & (indexj < array[0].length);
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        if (indexj == array.length - 1){
            indexj = 0;
            indexi++;
        }
        else{
            indexj++;
        }
        return array[indexi][indexj];
    }
}
