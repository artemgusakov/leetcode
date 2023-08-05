package easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">Task on leetcode</a>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        for (int firstWordLetterIndex = 0; firstWordLetterIndex < strs[0].length(); firstWordLetterIndex++) {
            int matchesCount = 1;
            char checkingLetter = strs[0].charAt(firstWordLetterIndex);
            for (int wordIndex = 1; wordIndex < strs.length; wordIndex++) {
                String currentWord = strs[wordIndex];
                if (firstWordLetterIndex < currentWord.length() && checkingLetter == currentWord.charAt(firstWordLetterIndex)) {
                    matchesCount++;
                } else {
                    break;
                }
            }
            if (matchesCount == strs.length) {
                result.append(checkingLetter);
            } else {
                return result.toString();
            }
        }
        return result.toString();
    }

    @Test
    void testSolution() {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        assertThat(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}))
            .isEmpty();
        assertThat(solution.longestCommonPrefix(new String[]{"flower", "flow", "flow"}))
            .isEqualTo("flow");
        assertThat(solution.longestCommonPrefix(new String[]{"", "flow", "flow"}))
            .isEmpty();
    }

}
