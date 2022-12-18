package vn.pandora.Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UtilClass {
	// lấy String từ list<String>
	public static String toStr_StrList(List<String> k) {
		return String.join(",", k);
	}

	// lấy String từ list các số nguyên
	public static String toStr_IntList(List<Integer> k) {
		return String.join(",", k.stream().map(Object::toString)
                .collect(Collectors.toList()));
	}

	public static List<Integer> toList_Int(String string) {

		List<Integer> list = Arrays.asList(string.split(",")).stream().map(s -> Integer.parseInt(s.trim()))
				.collect(Collectors.toList());
		return list;
	}

	public static List<String> toList_Str(String string) {

		List<String> list = Arrays.asList(string.split(","));

		return list;
	}
}
