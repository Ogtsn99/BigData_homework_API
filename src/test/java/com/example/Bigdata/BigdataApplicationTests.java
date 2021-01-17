package com.example.Bigdata;

import com.example.Bigdata.helper.JsonParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

@SpringBootTest
class BigdataApplicationTests {

	@Test
	void jsonToArray2d() {
		JsonParser jsonParser = new JsonParser();
		String s = "[[15, 2, 3], [4, 5, 6]]";
		ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
		arrayLists.add(new ArrayList<Integer>());
		arrayLists.get(0).add(15);
		arrayLists.get(0).add(2);
		arrayLists.get(0).add(3);
		arrayLists.add(new ArrayList<Integer>());
		arrayLists.get(1).add(4);
		arrayLists.get(1).add(5);
		arrayLists.get(1).add(6);
		assertEquals(arrayLists, jsonParser.toIntegerArray2d(s));
	}

}
