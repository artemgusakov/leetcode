package easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">Task on leetcode</a>
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }

    @Test
    void testSolution() {
        ClimbingStairs solution = new ClimbingStairs();
        assertThat(solution.climbStairs(2)).isEqualTo(2);
        assertThat(solution.climbStairs(3)).isEqualTo(3);
        assertThat(solution.climbStairs(4)).isEqualTo(5);
        assertThat(solution.climbStairs(5)).isEqualTo(8);
        assertThat(solution.climbStairs(45)).isEqualTo(1836311903);
    }

}
