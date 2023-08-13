package easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * <a href="https://leetcode.com/problems/sqrtx/">Task on leetcode</a>
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 * <p>
 * You must not use any built-in exponent function or operator.
 * <p>
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 * <p>
 * Example 1:
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * Example 2:
 * <p>
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 * <p>
 * Constraints:
 * <p>
 * 0 <= x <= 2^31 - 1
 */
public class Sqrt {

    public int mySqrtFast(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int start = 1;
        int end = x / 2;

        while (start < end) {
            int mid = (start + (end - start) / 2) + 1;

            int div = x / mid;
            if (div == mid) return mid;
            if (div > mid) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }


        return start;
    }


    //http://oldskola1.narod.ru/Kiselev07/K07.htm
    public int mySqrt(int x) {
        System.out.println("Incoming number is " + x);
        if (x == 1 || x == 0) {
            return x;
        }
        System.out.println();
        System.out.println("Splitting incoming into tenses");
        List<Integer> arr = new ArrayList<>();
        while (x > 0) {
            System.out.println("x % 100 = " + x % 100);
            arr.add(x % 100);
            x = x / 100;
        }


        System.out.println();
        System.out.println("Searching for square root");

        int closestSquare = 0;
        while (closestSquare * closestSquare <= arr.get(arr.size() - 1)) {
            closestSquare++;
        }
        closestSquare -= 1;

        System.out.println("The first number of the result is " + closestSquare);
        int remainder = arr.get(arr.size() - 1) - closestSquare * closestSquare;
        String result = String.valueOf(closestSquare);


        for (int i = arr.size() - 2; i >= 0; i--) {
            String n = arr.get(i) <= 9 ? "0" + arr.get(i) : String.valueOf(arr.get(i));
            int minuend = Integer.parseInt(remainder + n);
            int subtrahend = Integer.parseInt(String.valueOf(Integer.parseInt(result) * 2) + 0);
            System.out.println("Work with " + minuend + " and start " + subtrahend);
            int missingNumber = 1;
            while ((subtrahend + missingNumber) * missingNumber <= minuend) {
                missingNumber++;
            }
            subtrahend = (subtrahend + (missingNumber - 1)) * (missingNumber - 1);
            result += (missingNumber - 1);
            System.out.println("Current result is " + result);
            remainder = minuend - subtrahend;
            System.out.println("The remainder is " + remainder);
        }
        System.out.println("The final result is " + result);
        return Integer.parseInt(result);
    }

    @Test
    void testSolution() {
        Sqrt solution = new Sqrt();
        assertThat(solution.mySqrtFast(16)).isEqualTo(4);
//        assertThat(solution.mySqrtFast(9)).isEqualTo(3);
//        assertThat(solution.mySqrtFast(4)).isEqualTo(2);
//        assertThat(solution.mySqrtFast(808909662)).isEqualTo(28441);
//        assertThat(solution.mySqrt(808909662)).isEqualTo(28441);
//        assertThat(solution.mySqrt(808909608)).isEqualTo(28441);
//        assertThat(solution.mySqrt(1024)).isEqualTo(32);
//        assertThat(solution.mySqrt(35782)).isEqualTo(189);
//        assertThat(solution.mySqrt(4082)).isEqualTo(63);
//        assertThat(solution.mySqrt(1234)).isEqualTo(35);
//        assertThat(solution.mySqrt(0)).isEqualTo(0);
//        assertThat(solution.mySqrt(1)).isEqualTo(1);
//        assertThat(solution.mySqrt(4)).isEqualTo(2);
//        assertThat(solution.mySqrt(8)).isEqualTo(2);
//        assertThat(solution.mySqrt(15)).isEqualTo(3);
    }
}
