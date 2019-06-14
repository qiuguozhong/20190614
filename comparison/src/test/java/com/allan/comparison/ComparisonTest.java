package com.allan.comparison;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ComparisonTest {

	@Test
	public void compareTest() {
		Long startTime = System.currentTimeMillis();
		String message1 = "test1|1=1|2=2|3=3^A4=5";
		String message2 = "test2|1=test-1|2=1-2|3=3|4=5";

		List<String> message1List = new ArrayList<>();
		List<String> message2List = new ArrayList<>();
		message1List.add(message1);
		message2List.add(message2);
		int[] tags = { 1, 2 };

		Comparison.compare(message1List, message2List, tags);

		Long endTime = System.currentTimeMillis();
		System.out.println("duration :" + (endTime - startTime));

	}

}
