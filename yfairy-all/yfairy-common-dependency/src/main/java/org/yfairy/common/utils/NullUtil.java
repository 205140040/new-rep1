package org.yfairy.common.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class NullUtil {
	private static <T> boolean isNull(T object) {
		if (null == object) {
			return true;
		} else {
			return false;
		}
	}

	private static <T> boolean isNotNull(T object) {
		if (null == object) {
			return false;
		} else {
			return true;
		}
	}

	public static <T> boolean isEmpty(T object) {
		return isNull(object);
	}

	public static <T> boolean isNotEmpty(T object) {
		return isNotNull(object);
	}

	public static <T> boolean isEmpty(String object) {
		return !StringUtils.hasText(object);
	}

	public static <T> boolean isNotEmpty(String object) {
		return StringUtils.hasText(object);
	}

	public static <T> boolean isEmpty(List<T> object) {
		if (isNull(object)) {
			return true;
		} else {
			if (object.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static <T> boolean isNotEmpty(List<T> object) {
		if (isNull(object)) {
			return false;
		} else {
			if (!object.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		String n1 = null;
		System.out.println("string is null:" + isEmpty(n1));
		System.out.println("string is null:" + isEmpty("    "));
		System.out.println("string is null:" + isEmpty("6667    "));
		System.out.println("string is notEmpty:" + isNotEmpty(n1));
		System.out.println("string is notEmpty:" + isNotEmpty("    "));
		System.out.println("string is notEmpty:" + isNotEmpty("6667    "));
		BigDecimal bg = null;
		System.out.println("object is null:" + isEmpty(bg));
		System.out.println("object is notEmpty:" + isNotEmpty(bg));
		List<String> list = null;
		System.out.println("list isEmpty " + isEmpty(list));
		System.out.println("list isNotEmpty " + isNotEmpty(list));
		List<String> list2 = new ArrayList<>();
		System.out.println("list is Empty " + isEmpty(list2));
		System.out.println("list is NotEmpty " + isNotEmpty(list2));
		List<String> list3 = new ArrayList<>();
		list3.add("8888");
		System.out.println("list is Empty " + isEmpty(list3));
		System.out.println("list is NotEmpty " + isNotEmpty(list3));
	}
}
