package easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * <a href="https://leetcode.com/problems/palindrome-number">Task on leetcode</a>
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * <p>
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * <p>
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        List<Integer> arr = new ArrayList<>();
        while (x != 0) {
            arr.add(x % 10);
            x = x / 10;
        }

        if (arr.size() == 1) {
            return true;
        }

        for (int j = 0; j < arr.size() / 2; j++) {
            if (!Objects.equals(arr.get(j), arr.get(arr.size() - 1 - j))) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testSolution() {
        PalindromeNumber solution = new PalindromeNumber();
        assertThat(solution.isPalindrome(121)).isTrue();
        assertThat(solution.isPalindrome(-121)).isFalse();
        assertThat(solution.isPalindrome(10)).isFalse();
        assertThat(solution.isPalindrome(5)).isTrue();
        assertThat(solution.isPalindrome(1234554321)).isTrue();
        assertThat(solution.isPalindrome(123454321)).isTrue();
    }


}

