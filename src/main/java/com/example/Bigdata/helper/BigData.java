package com.example.Bigdata.helper;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BigData {

    public static Set<String> lsh(ArrayList<ArrayList<Integer>> sig, int r, int b){
        Set <String> set = new TreeSet<>();
        for (int i = 0; i < sig.size(); i += r) {
            Map<List<Integer>, ArrayList<Integer>> map = new HashMap<>();
            for(int j = 0; j < sig.get(0).size(); j++){
                List<Integer> list = new LinkedList<>();
                for(int k = i; k < i+r; k++){
                    list.add(sig.get(k).get(j));
                }
                if(!map.containsKey(list)) {
                    map.put(list, new ArrayList<>());
                }else {
                    ArrayList<Integer> tmp = map.get(list);
                    for(int l: tmp) {
                        set.add("C" + (l+1) + "-" + "C" + (j+1));
                    }
                }
                map.get(list).add(j);
            }
        }
        return set;
    }
}
