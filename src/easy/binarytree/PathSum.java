package easy.binarytree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/path-sum/">Task on leetcode</a>
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 * */
public class PathSum {

    int sum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val)
            || hasPathSum(root.right, targetSum - root.val);
    }

    @Test
    void testSolution() {
        PathSum solution = new PathSum();
        assertThat(solution.hasPathSum(
            new TreeNode(5,
                new TreeNode(4,
                    new TreeNode(11,
                        new TreeNode(7),
                        new TreeNode(2)),
                    null),
                new TreeNode(8,
                    new TreeNode(13),
                    new TreeNode(4,
                        null,
                        new TreeNode(1)))),
            22
        )).isTrue();

        assertThat(solution.hasPathSum(
            null,
            0
        )).isFalse();
    }
}
