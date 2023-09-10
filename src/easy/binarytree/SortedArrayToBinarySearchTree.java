package easy.binarytree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int middle = nums.length / 2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        int[] left = Arrays.copyOfRange(nums, 0, nums.length / 2);
        treeNode.left = sortedArrayToBST(left);
        int[] right = Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length);
        treeNode.right = sortedArrayToBST(right);
        return treeNode;
    }

    void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    @Test
    void testSolution() {
        SortedArrayToBinarySearchTree solution = new SortedArrayToBinarySearchTree();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{3, 5, 8});
        assertThat(treeNode)
            .usingRecursiveComparison()
            .isEqualTo(new TreeNode(5,
                new TreeNode(3),
                new TreeNode(8)
            ));
        treeNode = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        assertThat(treeNode)
            .usingRecursiveComparison()
            .isEqualTo(new TreeNode(0,
                new TreeNode(-3,
                    new TreeNode(-10),
                    null),
                new TreeNode(9,
                    new TreeNode(5),
                    null)));
    }

}
