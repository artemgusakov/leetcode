package easy.binarytree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">Task on leetcode</a>
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 * <p>
 * Constraints:
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * Post-order, LRN
 * Recursively traverse the current node's left subtree.
 * Recursively traverse the current node's right subtree.
 * Visit the current node.
 * Post-order traversal can be useful to get postfix expression of a binary expression tree.
 */

public class BinaryTreePostorderTraversal {

    public ArrayList<Integer> result;

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            postorderTraversalRecursive(root.left);
            postorderTraversalRecursive(root.right);
            result.add(root.val);
        }
        return result;
    }


    public List<Integer> postorderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int lastVisited = -101;
        TreeNode cursor = root; //set cursor to the tree root
        while (!stack.empty() || cursor != null) {
            if (cursor != null) { //if current cursor not null add it to the stack and goes to its left subtree
                stack.push(cursor);
                cursor = cursor.left;
            } else { //if cursor null, which means we have got a bottom of all left subtrees
                TreeNode peek = stack.peek(); // peek the last non-null cursor from the stack
                if (peek.right == null) { // if its right subtree is null - it means we can process this node
                    TreeNode pop = stack.pop();
                    result.add(pop.val);
                    lastVisited = pop.val; // save value of the node as the last visited and goes to the next iteration
                } else if (peek.right.val == lastVisited) { // if the peek has right subtree need to check whether we have visited it or not
                    TreeNode pop = stack.pop(); // if we have then the node considering as the last and should be processed
                    result.add(pop.val);
                    lastVisited = pop.val;
                } else {
                    cursor = peek.right; // In other cases just turn to right subtree.
                }

            }
        }
        return result;
    }

    @Test
    void testSolution() {
        BinaryTreePostorderTraversal solution = new BinaryTreePostorderTraversal();

        solution.result = new ArrayList<>();
        assertThat(solution.postorderTraversalRecursive(
            new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)
            ))).isEqualTo(List.of(3, 2, 1));

        solution.result = new ArrayList<>();
        assertThat(solution.postorderTraversalStack(null)).isEqualTo(List.of());

        solution.result = new ArrayList<>();
        assertThat(solution.postorderTraversalStack(
            new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)
            ))).isEqualTo(List.of(3, 2, 1));

        solution.result = new ArrayList<>();
        assertThat(solution.postorderTraversalRecursive(null)).isEqualTo(List.of());
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
