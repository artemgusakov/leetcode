package easy.binarytree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/description/">Task on leetcode</a>
 * <p>
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * <p>
 * Example 2:
 * <p>
 * Input: root = []
 * Output: []
 * Example 3:
 * <p>
 * Input: root = [1]
 * Output: [1]
 * <p>
 * Pre-order, NLR
 * Visit the current node (in the figure: position red).
 * Recursively traverse the current node's left subtree.
 * Recursively traverse the current node's right subtree.
 * The pre-order traversal is a topologically sorted one,
 * because a parent node is processed before any of its child nodes is done.
 */
public class BinaryTreePreorderTraversal {

    private List<Integer> result;

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        preorderTraversalRecursive(root.left);
        preorderTraversalRecursive(root.right);
        return result;
    }

    public List<Integer> preorderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            if (root != null) { // if it's not the end of a subtree
                result.add(root.val); // visits node
                stack.push(root); // pushes node in stack for history
                root = root.left; // goes to the left subtree
            } else { //when reached the end of the left subtree
                TreeNode pop = stack.pop(); // gets node from history
                root = pop.right; // look into right subtree of the current node
            }
        }
        return result;
    }

    @Test
    void testSolution() {
        BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();
        solution.result = new ArrayList<>();
        assertThat(solution.preorderTraversalRecursive(
            new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)
            ))).isEqualTo(List.of(1, 2, 3));

        solution.result = new ArrayList<>();
        assertThat(solution.preorderTraversalStack(
            new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)
            ))).isEqualTo(List.of(1, 2, 3));

        solution.result = new ArrayList<>();
        assertThat(solution.preorderTraversalStack(null)).isEqualTo(List.of());

        solution.result = new ArrayList<>();
        assertThat(solution.preorderTraversalStack(
            new TreeNode(3, new TreeNode(1), new TreeNode(2)))).isEqualTo(List.of(3, 1, 2));
    }
}
