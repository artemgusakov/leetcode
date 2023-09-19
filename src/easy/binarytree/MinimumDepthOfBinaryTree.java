package easy.binarytree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">Task on leetcode</a>
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;
        if (left == 1) {
            return right;
        } else if (right == 1) {
            return left;
        } else {
            return Math.min(left, right);
        }
    }

    @Test
    void testSolution() {
        MinimumDepthOfBinaryTree solution = new MinimumDepthOfBinaryTree();
        assertThat(solution.minDepth(
            new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                    new TreeNode(15),
                    new TreeNode(7)))
        )).isEqualTo(2);
        assertThat(solution.minDepth(
            new TreeNode(2,
                null,
                new TreeNode(3,
                    null,
                    new TreeNode(4,
                        null,
                        new TreeNode(5,
                            null,
                            new TreeNode(6)))))
        )).isEqualTo(5);
    }

}
