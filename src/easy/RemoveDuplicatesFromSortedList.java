package easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">Task on leetcode</a>
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * <p>
 * Return the linked list sorted as well.
 * <p>
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 * <p>
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode();
        int currentValue = head.val;
        ListNode current = new ListNode(currentValue);
        head = head.next;
        dummyHead.next = current;
        while (head != null) {
            if (head.val != currentValue) {
                currentValue = head.val;
                current.next = new ListNode(head.val);
                current = current.next;
            }
            head = head.next;
        }

        return dummyHead.next;
    }

    @Test
    void testSolution() {
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
//        assertThat(solution.deleteDuplicates(new ListNode(1)))
//            .usingRecursiveComparison()
//                .isEqualTo(new ListNode(1));
        assertThat(solution.deleteDuplicates(
            new ListNode(1,
                new ListNode(1,
                    new ListNode(2,
                        new ListNode(3,
                            new ListNode(3)))))))
            .usingRecursiveComparison()
            .isEqualTo(
                new ListNode(1,
                    new ListNode(2,
                        new ListNode(3))));
//        assertThat(solution.deleteDuplicates(null)).isEqualTo(null);
    }


    private class ListNode {
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
