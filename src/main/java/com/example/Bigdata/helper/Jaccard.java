package com.example.Bigdata.helper;

import com.sun.source.tree.Tree;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Jaccard {

    public static Set<String> getShingles(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        Set <String> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            if(i + 1 >= k){
                hashSet.add(stringBuilder.toString());
                stringBuilder.deleteCharAt(0);
            }
        }
        return hashSet;
    }

    public static double compute(String s, String t) { return compute(s, t, 2); }

    public static double compute(String s, String t, int k) {
        Set<String> s_hashSet = getShingles(s, k);
        Set<String> t_hashSet = getShingles(t, k);
        double countSame = 0;
        for (String str : t_hashSet) {
            if(s_hashSet.contains(str)) {
                countSame++;
            }
        }
        double all = s_hashSet.size() + t_hashSet.size() - countSame;
        return countSame/all;
    }

    public static Map<String, Double> compute(ArrayList<ArrayList<Integer>> matrix) {
        System.out.println(matrix);
        int r_size = matrix.size();
        int c_size = matrix.get(0).size();
        Map map = new TreeMap();
        for (int i = 0; i < c_size; i++) {
            for (int j = i+1; j < c_size; j++) {
                double same = 0;
                double all = 0;
                for (int k = 0; k < r_size; k++) {
                    if(matrix.get(k).get(i) == 0 && matrix.get(k).get(j) == 0) continue;
                    else if(matrix.get(k).get(i) == 1 && matrix.get(k).get(j) == 1) {all++; same++;}
                    else all++;
                }

                String key = "C" + (i+1) + "-" + "C" + (j+1);
                map.put(key, same/all);
            }
        }
        return map;
    }

    public static Map<String, Integer> getMinhash(ArrayList<ArrayList<Integer>> matrix, ArrayList<Integer> array) {
        System.out.println(matrix);
        System.out.println(array);
        Map<String, Integer> map = new TreeMap<>();
        int cnt = 1;

        for(int i : array) {
            i--;
            for(int j = 0; j < matrix.get(i).size(); j++){
                if(matrix.get(i).get(j) == 1 && !map.containsKey("h(C"+(j+1) + ")")) {
                    map.put("h(C" + (j+1) + ")", cnt);
                }
            }
            cnt++;
        }
        return map;
    }
}
