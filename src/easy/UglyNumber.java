package easy;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * <p>
 * Given an integer n, return true if n is an ugly number.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: true
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * Example 3:
 * <p>
 * Input: n = 14
 * Output: false
 * Explanation: 14 is not ugly since it includes the prime factor 7.
 */

public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(-14));
    }

    public boolean isUgly(int n) {

        if (n < 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        while (n > 1) {
            if (n % 5 == 0) {
                n = n / 5;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 2 == 0) {
                n = n / 2;
            } else {
                break;
            }
        }
        return n == 1;
    }
}
