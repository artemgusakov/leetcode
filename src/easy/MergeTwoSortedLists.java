package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Task on leetcode</a>
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * Example 1
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * <p>
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * <p>
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */

public class MergeTwoSortedLists {

    @ParameterizedTest
    @MethodSource("provideData")
    void testSolution(ListNode list1, ListNode list2, ListNode expectedResult) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        assertThat(solution.mergeTwoLists(list1, list2))
            .usingRecursiveComparison()
            .isEqualTo(expectedResult);
    }

    ListNode root = new ListNode();

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode(-1);

        ListNode current = new ListNode();
        if (list1.val < list2.val) {
            current.val = list1.val;
            list1 = list1.next;
        } else {
            current.val = list2.val;
            list2 = list2.next;
        }
        head.next = current;

        while (list1 != null || list2 != null) {

            int l1Value = list1 != null ? list1.val : Integer.MAX_VALUE;
            int l2Value = list2 != null ? list2.val : Integer.MAX_VALUE;

            if (l1Value < l2Value) {
                current.next = new ListNode(l1Value);
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = new ListNode(l2Value);
                current = current.next;
                if (list2 != null) {
                    list2 = list2.next;
                }
            }
        }

        return head.next;
    }

    public static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(null, null, null),
            Arguments.of(new ListNode(), new ListNode(), new ListNode(0, new ListNode(0))),
            Arguments.of(new ListNode(1), new ListNode(), new ListNode(0, new ListNode(1))),
            Arguments.of(new ListNode(), new ListNode(1), new ListNode(0, new ListNode(1))),
            Arguments.of(
                new ListNode(1,
                    new ListNode(2,
                        new ListNode(4))),
                new ListNode(1,
                    new ListNode(3,
                        new ListNode(4))),
                new ListNode(1,
                    new ListNode(1,
                        new ListNode(2,
                            new ListNode(3,
                                new ListNode(4,
                                    new ListNode(4))))))
            )
        );
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
