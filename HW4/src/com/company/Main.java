package com.company;

public class Main {

    public static void main(String[] args) {
        Integer[][] myArray2 = new Integer[5][5];
        for (int j = 0; j < 5; j++){
            for (int i = 0; i < 5; i++) {
                myArray2[j][i] = (i + 1) * (j + 1);
            }
        }
        ArrayIterator ar1 = new ArrayIterator(new Integer[] {1, 4, 3, 7, 9, 9, 6, 4});
        ArrayIterator ar2 = new ArrayIterator(new Integer[] {3, 6, 4, 8});
        Array2DIterator ar3 = new Array2DIterator(myArray2);
        IterIterator ar4 = new IterIterator(ar1, ar2);
        ArrayIterator ar11 = new ArrayIterator(new Integer[] {6, 4, 6, 7, 9});
        SorIIterator ar5 = new SorIIterator(ar11);
        System.out.println("T1");
        System.out.println(ar1.next());
        System.out.println("T2");
        for (int i = 0; i < 6; i++) {
            System.out.println(ar3.next());
        }
        System.out.println("T3");
        System.out.println(ar4.next());
        System.out.println("T4");
        System.out.println(ar5.next());
        System.out.println(ar5.next());
        System.out.println("T5");
        FlatIterator ar6 = new FlatIterator(ar5);
        System.out.println(ar6.next());
        System.out.println(ar6.next());
    }
}
