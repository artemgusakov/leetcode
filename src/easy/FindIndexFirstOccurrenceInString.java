package easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/">Task on leetcode</a>
 * <p>
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 * <p>
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */
public class FindIndexFirstOccurrenceInString {

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) {
                return -1;
            }
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean found = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Test
    void testSolution() {
        FindIndexFirstOccurrenceInString solution = new FindIndexFirstOccurrenceInString();

        assertThat(solution.strStr("sadbutsad", "sad")).isEqualTo(0);
        assertThat(solution.strStr("leetcode", "leeto")).isEqualTo(-1);
        assertThat(solution.strStr("a", "a")).isEqualTo(0);
        assertThat(solution.strStr("a", "aaa")).isEqualTo(-1);
        assertThat(solution.strStr("mississippi", "issi")).isEqualTo(1);
        assertThat(solution.strStr("mississippi", "issipi")).isEqualTo(-1);
    }


}
