package easy.binarytree;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Task on leetocde</a>
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * <p>
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode != null && treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode != null && treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }

    int depth = 0;

    public int maxDepthR(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(maxDepthR(root.right), maxDepthR(root.left));
    }

    @Test
    void testSolution() {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
//        assertThat(solution.maxDepth(
//            new TreeNode(3,
//                new TreeNode(9),
//                new TreeNode(20, new TreeNode(15), new TreeNode(7))
//            )
//        )).isEqualTo(3);

        assertThat(solution.maxDepthR(
            new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
            )
        )).isEqualTo(3);

//        assertThat(solution.maxDepth(
//            new TreeNode(1, null, new TreeNode(2))
//        )).isEqualTo(2);
//
//        assertThat(solution.maxDepth(
//            new TreeNode(0)
//        )).isEqualTo(1);
//
//        assertThat(solution.maxDepth(
//            new TreeNode(2,
//                null,
//                new TreeNode(3,
//                    null,
//                    new TreeNode(4,
//                        null,
//                        new TreeNode(5,
//                            null,
//                            new TreeNode(6)))))
//        )).isEqualTo(5);
//
//        assertThat(solution.maxDepth(
//            new TreeNode(0,
//                new TreeNode(0,
//                    new TreeNode(0),
//                    null),
//                new TreeNode(0,
//                    null,
//                    new TreeNode(0,
//                        null,
//                        new TreeNode(0)))
//            )
//        )).isEqualTo(4);
//
//        assertThat(solution.maxDepth(
//            new TreeNode(0,
//                new TreeNode(2,
//                    new TreeNode(1,
//                        new TreeNode(5),
//                        new TreeNode(1))
//                    , null),
//                new TreeNode(4,
//                    new TreeNode(3,
//                        null,
//                        new TreeNode(6)),
//                    new TreeNode(-1,
//                        null,
//                        new TreeNode(8)))
//            ))).isEqualTo(4);
    }

}
