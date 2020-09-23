package com.company;

public class Matrix {
    private int[][] mat;
    private  int a, b;
    public Matrix(int a, int b) {
        this.a = a;
        this.b = b;
        this.mat = new int[a][b];
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                this.mat[i][j] = 0;
            }
        }
    }
    public void randMat() {
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                mat[i][j] = (int) (-20 + Math.random()*50);
            }
        }
    }
    public void printMat() {
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }
    public Matrix sumMat(Matrix other) {
        if ((a == other.a)&(b == other.b)){
            Matrix res = new Matrix(a, b);
            for (int i = 0; i < a; i++){
                for (int j = 0; j < b; j++){
                    res.mat[i][j] = mat[i][j] + other.mat[i][j];
                }
            }
            return res;
        }
        System.out.println("Different sizes");
        Matrix res = new Matrix(0, 0);
        return res;
    }
    public Matrix difMat(Matrix other) {
        if ((a == other.a)&(b == other.b)){
            Matrix res = new Matrix(a, b);
            for (int i = 0; i < a; i++){
                for (int j = 0; j < b; j++){
                    res.mat[i][j] = mat[i][j] - other.mat[i][j];
                }
            }
            return res;
        }
        System.out.println("Different sizes");
        Matrix res = new Matrix(0, 0);
        return res;
    }
    public Matrix mulNumMat(int n) {
        Matrix res = new Matrix(a, b);
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                res.mat[i][j] = mat[i][j]*n;
            }
        }
        return res;
    }
    public Matrix mulMat(Matrix other) {
        if (b == other.a){
            Matrix res = new Matrix(a, other.b);
            for (int i = 0; i < a; i++){
                for (int j = 0; j < other.b; j++) {
                    for (int k = 0; k < b; k++) {
                        res.mat[i][j] = res.mat[i][j] + mat[i][k] * other.mat[k][j];
                    }
                }
            }
            return res;
        }
        System.out.println("Different sizes");
        Matrix res = new Matrix(0, 0);
        return res;
    }
    public Matrix transMat() {
        Matrix res = new Matrix(b, a);
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                res.mat[j][i] = mat[i][j];
            }
        }
        return res;
    }
    public Matrix powMat(int n) {
        if (n == 1) {
            return this;
        }
        else if ((n > 1)&(a == b)){
            Matrix res = this;
            for (int i = 0; i < n - 1; i++) {
                res = res.mulMat(this);
            }
            return res;
        }
        System.out.println("Incorrect size or power");
        Matrix res = new Matrix(0, 0);
        return res;
    }

}
