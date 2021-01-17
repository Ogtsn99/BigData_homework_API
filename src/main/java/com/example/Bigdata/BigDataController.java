package com.example.Bigdata;

import com.example.Bigdata.helper.BigData;
import com.example.Bigdata.helper.Jaccard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@RestController
public class BigDataController {

    @GetMapping("/shingles")
    Set<String> toShingles(@RequestBody Map reqBody){
        return Jaccard.getShingles((String)reqBody.get("s"), (Integer) reqBody.get("k"));
    }

    @GetMapping("/jaccard")
    double jaccard(@RequestBody Map reqBody){
        return Jaccard.compute((String)reqBody.get("s"), (String)reqBody.get("t"), (Integer) reqBody.get("k"));
    }

    @GetMapping("/matrix-jaccard")
    Map<String, Double> matrixJaccard(@RequestBody Map reqBody){
        return Jaccard.compute((ArrayList<ArrayList<Integer>>) reqBody.get("matrix"));
    }

    @GetMapping("/minhash")
    Map<String, Integer> minhash(@RequestBody Map reqBody) {
        return Jaccard.getMinhash((ArrayList<ArrayList<Integer>>) reqBody.get("matrix"),
                (ArrayList<Integer>) reqBody.get("R"));
    }

    @GetMapping("/lsh")
    Set<String> lsh(@RequestBody Map reqBody) {
        return BigData.lsh((ArrayList<ArrayList<Integer>>) reqBody.get("sig"),
                (Integer) reqBody.get("r"), (Integer) reqBody.get("b"));
    }
}
