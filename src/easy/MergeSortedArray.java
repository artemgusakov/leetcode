package easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/">Task on leetcode</a>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * <p>
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * <p>
 * Example 3:
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 */
public class MergeSortedArray {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex = m + n - 1;
        int indexM = m - 1;
        int indexN = n - 1;
        while (lastIndex >= 0) {
            if (indexM >= 0 && indexN >= 0) {
                if (nums1[indexM] > nums2[indexN]) {
                    nums1[lastIndex] = nums1[indexM];
                    indexM--;
                } else {
                    nums1[lastIndex] = nums2[indexN];
                    indexN--;
                }
            } else if (indexN >= 0) {
                nums1[lastIndex] = nums2[indexN];
                indexN--;
            }
            lastIndex--;
        }
        return nums1;
    }

    @Test
    public void testSolution() {
        MergeSortedArray solution = new MergeSortedArray();
        assertThat(solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3))
            .containsExactly(1, 2, 2, 3, 5, 6);
        assertThat(solution.merge(new int[]{2, 0}, 1, new int[]{1}, 1))
            .containsExactly(1, 2);
        assertThat(solution.merge(new int[]{1}, 1, new int[]{}, 0))
            .containsExactly(1);
        assertThat(solution.merge(new int[]{0}, 0, new int[]{1}, 1))
            .containsExactly(1);

    }
}
