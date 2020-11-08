package com.company;

public class Main {

    public static void main(String[] args) {
        //вывод чисел от 1 до n
        numbers(5);
        //Вхождение элемента в массив
        int[] array = new int[100000000];
        for (int i = 0; i < 100000000; i++){
            array[i] = i * 20;
        }
        int n = 20000000;
        long t1, t2;
        t1 = System.currentTimeMillis();
        System.out.println(inArrayBin(n, array, 0, array.length- 1) );
        t2 =  System.currentTimeMillis();
        System.out.println("Время выполнения двоичным поиском в мс " + (t2 - t1));

        t1 = System.currentTimeMillis();
        System.out.println(inArrayFor(n, array) );
        t2 =  System.currentTimeMillis();
        System.out.println("Время выполнения перебором в мс " + (t2 - t1));
        //Нахождение корня уравнения на отрезке с заданной точностью
        System.out.println(accur(0, 10, 0.001));
        //Бинарное дерево
        BinTree tree = new BinTree(10);
        tree.add(5);
        tree.add(9);
        tree.add(4);
        tree.add(18);
        tree.add(2);
        tree.printTree();
        tree.del(4);
        tree.printTree();
        System.out.println(tree.contains(9));
        System.out.println(tree.contains(4));
    }
    static double f(double x) {
        return x * (x + 5) + 6 * x - 17;
    }
    static double accur(double a, double b, double eps) {
        double m = (a + b) / 2.0;
        if (Math.abs(f(m)) <= eps){
            return m;
        }
        if (f(a) * f(m) <= 0){
            return accur(a, m, eps);
        }
        else {
            return accur(m, b, eps);
        }

    }

    static void numbers(int n) {
        if (n > 1) {
            numbers(n - 1);
        }
        System.out.println(n);
    }

    static boolean inArrayFor(int n, int[] arr) {
        for (int i: arr){
            if (i == n){
                return true;
            }
        }
        return false;

    }

    static boolean inArrayBin(int n, int[] arr, int startInd, int endInd) {
        if (endInd - startInd + 1 > 0) {
            int medInd = startInd + (endInd - startInd + 1) /2;
            if (n < arr[medInd]) {
                return inArrayBin(n, arr, startInd, medInd - 1);
            }
            else if (n > arr[medInd]) {
                return inArrayBin(n, arr, medInd + 1, endInd);
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }

    }
}
