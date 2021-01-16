package com.example.Bigdata;

import com.example.Bigdata.helper.Jaccard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class BigDataController {

    @GetMapping("/shingles")
    Set<String> toShingles(@RequestParam("s") String s, @RequestParam("k") int k){
        return Jaccard.getShingles(s, k);
    }

    @GetMapping("/jaccard")
    double toShingles(@RequestParam("s") String s, @RequestParam("t") String t, @RequestParam("k") int k){
        return Jaccard.compute(s, t, k);
    }

}
