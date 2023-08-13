package easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * <a href="https://leetcode.com/problems/length-of-last-word/">Task on leetcode</a>
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal consisting of non-space characters only.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 * <p>
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 * <p>
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int lastWordLength = 0;
        char space = ' ';
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            if (currentChar != space) {
                lastWordLength++;
            } else if (lastWordLength > 0) {
                return lastWordLength;
            }
        }
        return lastWordLength;
    }

    @Test
    void testSolution() {
        LengthOfLastWord solution = new LengthOfLastWord();
        assertThat(solution.lengthOfLastWord("Hello World")).isEqualTo(5);
        assertThat(solution.lengthOfLastWord("   fly me   to   the moon  ")).isEqualTo(4);
        assertThat(solution.lengthOfLastWord("luffy is still joyboy")).isEqualTo(6);
        assertThat(solution.lengthOfLastWord("a")).isEqualTo(1);
    }
}
