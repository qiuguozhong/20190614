package com.allan.comparison;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.allan.comparison.utils.StringUtils;

public class Comparison {

	private static final String KEY_UNMATCHED = "unmatched";
	private static final String KEY_RESULT = "result";
	private static final String COMMA = ",";
	private static final String COMPARE_FAILED = "Failed";
	private static final String COMPARE_PASS = "Pass";
	private static final String REGEX_EQUAL = "=";
	private static final byte[] SOHARRAY = { 1 };
	private static final String SOHSTR = new String(SOHARRAY);
	private static final String REGEX_SPLIT = SOHSTR + "|\\^A|\\|";

	public static Map<String, String> compare(String m1, String m2) {
		Map<String, String> resultMap = new LinkedHashMap<>();
		String result = "";
		StringBuilder unmatched = new StringBuilder();

		List<Integer> m1Keys = getTagKeys(m1);
		List<Integer> m2Keys = getTagKeys(m2);
		m1Keys.addAll(m2Keys);

		for (Integer key : m1Keys) {
			String m1TagValue = getValueByTag(m1, key);
			String m2TagValue = getValueByTag(m2, key);
			if (!"".equals(m1TagValue) && !"".equals(m2TagValue) && m2TagValue.contains(m1TagValue)) {
				result = !result.equals(COMPARE_FAILED) ? COMPARE_PASS : COMPARE_FAILED;
			} else {
				unmatched.append(key).append(COMMA);
				result = COMPARE_FAILED;
			}
		}
		resultMap.put(KEY_RESULT, result);
		resultMap.put(KEY_UNMATCHED, unmatched.toString());
		return resultMap;
	}

	public static String getValueByTag(String message, int tag) {
		String[] keyValueArray = message.split(REGEX_SPLIT);
		for (String keyValue : keyValueArray) {
			String[] tagArray = keyValue.split(REGEX_EQUAL);
			String tagKey = tagArray[0];
			if (tagArray.length > 1 && StringUtils.isNumeric(tagKey) && tag == Integer.parseInt(tagKey)) {
				return tagArray[1];
			}
		}
		return "";
	}

	public static List<Integer> getTagKeys(String message) {
		List<Integer> tagKeys = new ArrayList<>();
		String[] array = message.split(REGEX_SPLIT);
		for (String tagValue : array) {
			String[] tagArray = tagValue.split(REGEX_EQUAL);
			if (tagArray.length > 1 && StringUtils.isNumeric(tagArray[0])) {
				tagKeys.add(Integer.parseInt(tagArray[0]));
			}

		}
		return tagKeys;
	}

	public static void compare(List<String> m1List, List<String> m2List, int[] tags) {
		for (String m2 : m2List) {
			Iterator<String> iterator = m1List.iterator();
			while (iterator.hasNext()) {
				String m1 = iterator.next();
				Boolean isMatch = true;
				for (int tag : tags) {
					String m1V = getValueByTag(m1, tag);
					String m2V = getValueByTag(m2, tag);
					if (!m2V.contains(m1V)) {
						isMatch = false;
						break;
					}
				}

				if (isMatch) {
					Map<String, String> resultMap = Comparison.compare(m1, m2);
					System.out.println(resultMap);
					iterator.remove();
					break;
				}
			}

		}
	}
}
