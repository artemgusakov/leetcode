package medium;

/**
 * https://leetcode.com/problems/add-two-numbers/description/?source=submission-ac
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultRootNode = new ListNode(l1.val + l2.val);
        l1 = l1.next;
        l2 = l2.next;
        ListNode currentNode = resultRootNode;
        int carry = 0;
        if (resultRootNode.val >= 10) {
            resultRootNode.val = resultRootNode.val - 10;
            carry = 1;
        }
        for (int i = 1; i <= 100; i++) {
            ListNode node = new ListNode();
            if (l1 != null && l2 != null) {
                int r = l1.val + l2.val + carry;
                if (r >= 10) {
                    node.val = r - 10;
                    carry = 1;
                } else {
                    node.val = r;
                    carry = 0;
                }
                currentNode.next = node;
                currentNode = node;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1 != null) {
                int r = l1.val + carry;
                if (r >= 10) {
                    node.val = r - 10;
                    carry = 1;
                } else {
                    node.val = r;
                    carry = 0;
                }
                currentNode.next = node;
                currentNode = node;
                l1 = l1.next;

            } else if (l2 != null) {
                int r = l2.val + carry;
                if (r >= 10) {
                    node.val = r - 10;
                    carry = 1;
                } else {
                    node.val = r;
                    carry = 0;
                }
                currentNode.next = node;
                currentNode = node;
                l2 = l2.next;
            } else {
                if (carry == 1) {
                    currentNode.next = new ListNode(1);
                }
                break;
            }
        }
        return resultRootNode;
    }
}

class ListNode {
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

/**
 * THE BEST SOLUTION
 * public medium.ListNode addTwoNumbers(medium.ListNode l1, medium.ListNode l2) {
 *         medium.ListNode dummyHead = new medium.ListNode(0);
 *         medium.ListNode curr = dummyHead;
 *         int carry = 0;
 *         while (l1 != null || l2 != null || carry != 0) {
 *             int x = (l1 != null) ? l1.val : 0;
 *             int y = (l2 != null) ? l2.val : 0;
 *             int sum = carry + x + y;
 *             carry = sum / 10;
 *             curr.next = new medium.ListNode(sum % 10);
 *             curr = curr.next;
 *             if (l1 != null)
 *                 l1 = l1.next;
 *             if (l2 != null)
 *                 l2 = l2.next;
 *         }
 *         return dummyHead.next;
 *     }
 * */
