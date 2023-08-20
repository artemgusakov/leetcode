package easy.binarytree;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <a href="https://leetcode.com/problems/same-tree/">Task on leetcode</a>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * <p>
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * <p>
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * <p>
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 */
public class SameTree {

    //The Pre-order traversal will be used, NLR
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        //On the first step checking incoming roots
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        while ((!pStack.empty() && !qStack.empty()) || p != null || q != null) {
            //on every step checking that both p and q have or haven't a value
            if ((p == null && q != null) || (p != null && q == null)) {
                return false;
            }

            if (p != null && q != null) {
                //visit nodes p and q
                if (p.val != q.val) {
                    return false;
                }
                //pushing nodes into the corresponding stacks and go to their left subtrees
                pStack.push(p);
                qStack.push(q);
                p = p.left;
                q = q.left;
            } else {
                //extraction nodes from the corresponding stacks and go to their right subtrees
                TreeNode pPop = pStack.pop();
                TreeNode qPop = qStack.pop();
                p = pPop.right;
                q = qPop.right;
            }
        }
        return true;
    }

    @Test
    void testSolution() {
        SameTree solution = new SameTree();
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertThat(solution.isSameTree(p, q)).isTrue();

        p = new TreeNode(1, new TreeNode(2), null);
        q = new TreeNode(1, null, new TreeNode(2));
        assertThat(solution.isSameTree(p, q)).isFalse();

        p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        assertThat(solution.isSameTree(p, q)).isFalse();

        p = null;
        q = new TreeNode(0);
        assertThat(solution.isSameTree(p, q)).isFalse();

        p = new TreeNode(1);
        q = new TreeNode(1, null, new TreeNode(2));
        assertThat(solution.isSameTree(p, q)).isFalse();

    }
}
