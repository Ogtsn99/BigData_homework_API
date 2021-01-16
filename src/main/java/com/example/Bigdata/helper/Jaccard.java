package com.example.Bigdata.helper;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Set;

@Component
public class Jaccard {

    public static Set<String> getShingles(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        Set <String> hashSet = new HashSet<>();
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

    public static Map<String, Double> compute(int [][] array) {
        int r_size = array.length;
        int c_size = array[0].length;
        Map map = new HashMap<String, Double>();
        for (int i = 0; i < c_size; i++) {
            for (int j = i+1; j < c_size; j++) {
                double same = 0;
                double all = 0;
                for (int k = 0; k < r_size; k++) {
                    if(array[k][i] == 0 && array[k][j] == 0) continue;
                    else if(array[k][i] == 1 && array[k][j] == 1) {all++; same++;}
                    else all++;
                }

                char l = (char)('A'+i);
                char r = (char)('A' + j);

                String key = "";
                key += l;
                key += r;
                map.put(key, same/all);
            }
        }
        return map;
    }
}
