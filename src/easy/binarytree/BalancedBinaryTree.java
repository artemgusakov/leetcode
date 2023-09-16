package easy.binarytree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/balanced-binary-tree/description/">Task on leetcode</a>
 * Given a binary tree, determine if it is height-balanced
 * .*/
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int dif = Math.abs(depth(root.left) - depth(root.right));
        if (dif <= 1 && isBalanced(root.right) && isBalanced(root.left)) {
            return true;
        }
        return false;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

//    public int height(TreeNode root) {
//        // Base case...
//        if (root == null)  {
//            return 0;
//        }
//        // Height of left subtree...
//        int leftHeight = height(root.left);
//        // Height of height subtree...
//        int rightHeight = height(root.right);
//        // In case of left subtree or right subtree unbalanced, return -1...
//        if (leftHeight == -1 || rightHeight == -1)  {
//            return -1;
//        }
//        // If their heights differ by more than ‘1’, return -1...
//        if (Math.abs(leftHeight - rightHeight) > 1)  {
//            return -1;
//        }
//        // Otherwise, return the height of this subtree as max(leftHeight, rightHight) + 1...
//        return Math.max(leftHeight, rightHeight) + 1;
//    }

    @Test
    void testSolution() {
        BalancedBinaryTree solution = new BalancedBinaryTree();
        assertThat(solution.isBalanced(
            new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)))
        )).isTrue();

        assertThat(
            solution.isBalanced(
                new TreeNode(1,
                    new TreeNode(2,
                        new TreeNode(3,
                            new TreeNode(4),
                            new TreeNode(4)),
                        new TreeNode(3)),
                    new TreeNode(2))
            )
        ).isFalse();

        assertThat(
            solution.isBalanced(
                new TreeNode(1,
                    new TreeNode(2,
                        new TreeNode(4, new TreeNode(8), null),
                        new TreeNode(5)),
                    new TreeNode(3,
                        new TreeNode(6),
                        null))
            )
        ).isTrue();

        assertThat(
            solution.isBalanced(
                new TreeNode(1,
                    new TreeNode(2,
                        new TreeNode(3,
                            new TreeNode(4),
                            null),
                        null),
                    new TreeNode(2,
                        null,
                        new TreeNode(3,
                            null,
                            new TreeNode(4))))

            )
        ).isFalse();


    }
}
