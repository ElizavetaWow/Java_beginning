package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> mis = new HashMap<Integer, String>();
        mis.put(1, "f");
        mis.put(2, "s");
        mis.put(3, "t");
        mis.put(4, "f");
        System.out.println(revMap(mis).toString());
        Map<Double, Boolean> mdb = new HashMap<Double, Boolean>();
        mdb.put(1.8, true);
        mdb.put(2.2, true);
        mdb.put(3.66, false);
        mdb.put(4.09, true);
        System.out.println(revMap(mdb).toString());
    }
    public static <K, V> Map<V, ArrayList<K>> revMap(Map<K, V> startMap){
        Map<V, ArrayList<K>> finMap = new HashMap<V, ArrayList<K>>();
        for (Map.Entry<K, V> item: startMap.entrySet()){
            V val = item.getValue();
            K key = item.getKey();
            ArrayList<K> newk;
            if (finMap.containsKey(val)){
                newk = new ArrayList<>(finMap.get(val));
            }
            else{
                newk = new ArrayList<>();
            }
            newk.add(key);
            finMap.put(val, newk);
        }
        return finMap;
    }
}
