package com.allan.comparison.utils;

import java.util.Arrays;

public class StringUtils {
	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

	public static boolean contains(int[] arr, int key) {
		return Arrays.stream(arr).anyMatch(i -> i == key);
	}
}
