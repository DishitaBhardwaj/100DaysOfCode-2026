/**
 * LeetCode 222 - Count Complete Tree Nodes
 */

//Need to count nodes in a complete binary tree without visiting every node

class Solution {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // perfect tree, so nodes can be counted directly
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode node) {

        int height = 0;

        while (node != null) {
            height++;
            node = node.left;
        }

        return height;
    }

    private int getRightHeight(TreeNode node) {

        int height = 0;

        while (node != null) {
            height++;
            node = node.right;
        }

        return height;
    }
}