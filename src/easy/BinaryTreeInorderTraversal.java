package easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">Task on leetcode</a>
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 2:
 * <p>
 * Input: root = []
 * Output: []
 * Example 3:
 * <p>
 * Input: root = [1]
 * Output: [1]
 */
public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> result;

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return this.result;
        }
        inorderTraversalRecursive(root.left);
        this.result.add(root.val);
        inorderTraversalRecursive(root.right);
        return this.result;
    }

    public List<Integer> inorderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode current = stack.pop();
                result.add(current.val);
                root = current.right;
            }
        }

        return result;
    }

    @Test
    void testSolution() {
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();

        solution.result = new ArrayList<>();
        assertThat(solution.inorderTraversalRecursive(
            new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)
            ))).isEqualTo(List.of(1, 3, 2));

        solution.result = new ArrayList<>();
        assertThat(solution.inorderTraversalStack(
            new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)
            ))).isEqualTo(List.of(1, 3, 2));

        solution.result = new ArrayList<>();
        assertThat(solution.inorderTraversalRecursive(new TreeNode(
            1, null, new TreeNode(2, new TreeNode(3), null)
        ))).isEqualTo(List.of(1, 3, 2));

        solution.result = new ArrayList<>();
        assertThat(solution.inorderTraversalStack(null)).isEqualTo(List.of());

        solution.result = new ArrayList<>();
        assertThat(solution.inorderTraversalRecursive(null)).isEqualTo(List.of());
    }


    class TreeNode {
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