package com.company;

public class Weights {
    private  int[] arr;
    public Weights(int[] val, int[] wght) {
        int lng = 0;
        for (int w : wght){
            lng += w;
        }
        this.arr = new int[lng];
        int k = 0;
        for (int i = 0; i < wght.length; i++){
            for (int j = 0; j < wght[i]; j++){
                arr[k] = val[i];
                k++;
            }
        }
    }
    public int randVal() {
        int i =(int) (Math.random()*(arr.length - 1));
        return arr[i];
    }
}
