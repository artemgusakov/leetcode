package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together.
 * 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII.
 * Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("XXXIX"));
        System.out.println(new RomanToInteger().romanToInt("XCIX"));
        System.out.println(new RomanToInteger().romanToInt("III"));
    }

    public int romanToInt(String s) {
        Map<String, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put("I", 1);
        romanToIntMap.put("V", 5);
        romanToIntMap.put("X", 10);
        romanToIntMap.put("L", 50);
        romanToIntMap.put("C", 100);
        romanToIntMap.put("D", 500);
        romanToIntMap.put("M", 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            Character nextChar = i < s.length() - 1 ? s.charAt(i + 1) : null;
            if(currentChar == 'I') {
                if (nextChar != null && nextChar == 'V') {
                    result += 4;
                    i = i + 1;
                } else if (nextChar != null && nextChar == 'X'){
                    result += 9;
                    i = i + 1;
                } else {
                    result += 1;
                }
            } else if (currentChar == 'X') {
                if (nextChar != null && nextChar == 'L') {
                    result += 40;
                    i = i + 1;
                } else if (nextChar != null && nextChar == 'C'){
                    result += 90;
                    i = i + 1;
                } else {
                    result += 10;
                }
            } else if (currentChar == 'C') {
                if (nextChar != null && nextChar == 'D') {
                    result += 400;
                    i = i + 1;
                } else if (nextChar != null && nextChar == 'M'){
                    result += 900;
                    i = i + 1;
                } else {
                    result += 100;
                }
            } else {
                result += romanToIntMap.get(String.valueOf(currentChar));
            }
        }
        return result;
    }

}
