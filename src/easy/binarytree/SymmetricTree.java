package easy.binarytree;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree/">Task on leetcode</a>
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * <p>
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 * <p>
 * Follow up: Could you solve it both recursively and iteratively?
 */
public class SymmetricTree {

    /**
     * Recursive solution
     * */
    boolean result = true;
    public boolean isSymmetricRecursive(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if ((left == null && right != null)
            || (left != null && right == null)) {
            result = false;
        }
        if (left != null && right != null) {
            if (left.val != right.val) {
                result = false;
            } else {
                isSymmetric(left.right, right.left);
                isSymmetric(left.left, right.right);
            }
        }
        return result;
    }

    /**
     * Stack solution
     * */
    public boolean isSymmetricStack(TreeNode root) {
        TreeNode leftSide = root.left;
        TreeNode rightSide = root.right;
        Stack<TreeNode> leftSideStack = new Stack<>();
        Stack<TreeNode> rightSideStack = new Stack<>();
        if ((leftSide == null && rightSide != null)
            || (leftSide != null && rightSide == null)) {
            return false;
        }
        while ((!leftSideStack.empty() && !rightSideStack.empty()) || leftSide != null || rightSide != null) {
            if ((leftSide == null && rightSide != null)
                || (leftSide != null && rightSide == null)) {
                return false;
            }

            if (leftSide != null && rightSide != null) {
                if (leftSide.val != rightSide.val) {
                    return false;
                }
                leftSideStack.push(leftSide);
                leftSide = leftSide.left;
                rightSideStack.push(rightSide);
                rightSide = rightSide.right;
            } else {
                TreeNode leftPop = leftSideStack.pop();
                leftSide = leftPop.right;
                TreeNode rightPop = rightSideStack.pop();
                rightSide = rightPop.left;
            }
        }
        return true;
    }

    @Test
    void testSolution() {
        SymmetricTree solution = new SymmetricTree();

        assertThat(solution.isSymmetricStack(
            new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)))
        )).isTrue();


        assertThat(solution.isSymmetricStack(
            new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)))
        )).isFalse();

        assertThat(solution.isSymmetricRecursive(
            new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)))
        )).isTrue();


        assertThat(solution.isSymmetricRecursive(
            new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)))
        )).isFalse();
    }
}
