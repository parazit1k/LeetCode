package org.PARAZITIK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();

        int result = 0;

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        String symbol;
        String previos = "";
        boolean next = false;

        for (int i = 0; i < s.length(); i++) {
            symbol = String.valueOf(s.charAt(i));
            if (Objects.equals(symbol, "I") || Objects.equals(symbol, "X") || Objects.equals(symbol, "C") && !next) {
                previos = symbol;
                next = true;
            } else if (next) {
                if (Objects.equals(previos, "I")) {
                    if (Objects.equals(symbol, "V")){
                        next = false;
                        result += 4;
                    }else if(Objects.equals(symbol, "X")){
                        next = false;
                        result += 9;
                    }
                } else if (Objects.equals(previos, "X")) {
                    if (Objects.equals(symbol, "L")){
                        next = false;
                        result += 40;
                    }else if(Objects.equals(symbol, "C")){
                        next = false;
                        result += 90;
                    }
                } else if (Objects.equals(previos, "C")) {
                    if(Objects.equals(symbol, "D")) {
                        next = false;
                        result += 400;
                    }else if(Objects.equals(symbol, "M")){
                        next = false;
                        result += 900;
                    }
                } else {
                    result += map.get(previos);
                    next = false;
                }
            } else {
                result += map.get(symbol);
            }
        }

        return result;
    }
}
