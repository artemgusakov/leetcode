package easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * <a href="https://leetcode.com/problems/plus-one/">Task on leetcode</a>
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * <p>
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 * <p>
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * <p>
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int needToAdd = 1;
        int sum;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + needToAdd;
            needToAdd = sum / 10;
            if (needToAdd == 0) {
                digits[i] = sum;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if (needToAdd > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    /** Elegant solution
     * for (int i = digits.length - 1; i >= 0; i--) {
     * if (digits[i] < 9) {
     * digits[i]++;
     * return digits;
     * } else {
     * digits[i] = 0;
     * }
     * }
     * <p>
     * int[] result = new int[digits.length + 1];
     * result[0] = 1;
     * return result;
     */

    @Test
    void testSolution() {
        PlusOne solution = new PlusOne();
        assertThat(solution.plusOne(new int[]{9, 9})).containsExactly(1, 0, 0);
        assertThat(solution.plusOne(new int[]{9})).containsExactly(1, 0);
        assertThat(solution.plusOne(new int[]{4, 3, 2, 1})).containsExactly(4, 3, 2, 2);
        assertThat(solution.plusOne(new int[]{4, 3, 2, 9})).containsExactly(4, 3, 3, 0);
        assertThat(solution.plusOne(new int[]{4, 3, 9, 9})).containsExactly(4, 4, 0, 0);
    }
}
