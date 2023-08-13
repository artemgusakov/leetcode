package easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/add-binary/">Task on leetcode</a>
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * <p>
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * <p>
 * Constraints:
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += Character.getNumericValue(a.charAt(i));
                i--;
            }
            if (j >= 0) {
                sum += Character.getNumericValue(b.charAt(j));
                j--;
            }
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }

    //        MY SOLUTION
    public String addBinary2(String a, String b) {
        int i = 0;
        StringBuilder result = new StringBuilder();
        boolean hasCarry = false;
        while (i <= a.length() - 1 || i <= b.length() - 1) {
            char aLast = i <= a.length() - 1 ? a.charAt(a.length() - 1 - i) : '0';
            char bLast = i <= b.length() - 1 ? b.charAt(b.length() - 1 - i) : '0';
            if (aLast == '1' && bLast == '1') {
                result.append(hasCarry ? '1' : '0');
                hasCarry = true;
            } else if (aLast == '0' && bLast == '0') {
                result.append(hasCarry ? '1' : '0');
                hasCarry = false;
            } else {
                if (hasCarry) {
                    result.append('0');
                } else {
                    result.append('1');
                }
            }
            i++;
        }
        if (hasCarry) {
            result.append('1');
        }
        return result.reverse().toString();
    }

    @Test
    void testSolution() {
        AddBinary solution = new AddBinary();
        assertThat(solution.addBinary("11", "1")).isEqualTo("100");
        assertThat(solution.addBinary("1010", "1011")).isEqualTo("10101");
        assertThat(solution.addBinary("1111", "1111")).isEqualTo("11110");
    }
}
