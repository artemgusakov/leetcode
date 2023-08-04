package easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidBracketsTest {
    @Test
    public void check() {
        ValidBracketsSolution service = new ValidBracketsSolution();
        assertThat(service.isValid("()")).isTrue();
        assertThat(service.isValid("()[]{}")).isTrue();
        assertThat(service.isValid("([)]")).isFalse();
        assertThat(service.isValid("([]())")).isTrue();
        assertThat(service.isValid("([{}])")).isTrue();
        assertThat(service.isValid("(){}}{")).isFalse();
        assertThat(service.isValid("){}{}")).isFalse();
    }
}
class ValidBracketsSolution {
    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentBracket = s.charAt(i);
            if (stack.empty()
                    && (currentBracket == ')' || currentBracket == ']' || currentBracket == '}')) {
                return false;
            }
            if (currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
                stack.push(currentBracket);
            } else {
                Character lastBracket = stack.pop();
                if (currentBracket == ')' && lastBracket != '(') {
                    return false;
                } else if (currentBracket == ']' && lastBracket != '[') {
                    return false;
                } else if (currentBracket == '}' && lastBracket != '{') {
                    return false;
                }
            }
        }
        return stack.empty();
    }

}
