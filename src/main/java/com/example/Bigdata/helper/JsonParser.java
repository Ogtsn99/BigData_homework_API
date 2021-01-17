package com.example.Bigdata.helper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JsonParser {
    public static ArrayList<ArrayList<Integer>> toIntegerArray2d(String s){
        s = s.replaceAll("", "");
        s = s.replaceAll("\"", "");
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(s.charAt(0) != '[') return null;
        int tmp = 0;
        int last = -1;
        for (int i = 1; i < s.length()-1; i++) {
            if(s.charAt(i) == '[') {
                arrayLists.add(new ArrayList<Integer>());
                last++;
            } else if(s.charAt(i) == ',' || s.charAt(i) == ']') {
                if(s.charAt(i-1) == ']' && s.charAt(i+1) == '['){
                    continue;
                }
                arrayLists.get(last).add(tmp);
                tmp = 0;
            } else {
                tmp *= 10;
                tmp += s.charAt(i) - '0';
            }
        }
        return arrayLists;
    }
}
