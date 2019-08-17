package com.qi.科大讯飞笔试;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 从一串字符串中找出所有数字并排序
 */

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int len = s.length();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                list.add(c - '0');
            }
        }

        Collections.sort(list);

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : list) {
            stringBuilder.append(i);
        }

        String result = stringBuilder.toString();
        System.out.println(result);
    }
}