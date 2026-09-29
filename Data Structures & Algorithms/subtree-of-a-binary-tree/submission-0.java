class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        // Check if the trees starting at these nodes are identical
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Search in the left and right subtrees
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        // Both are null -> same
        if (p == null && q == null) {
            return true;
        }

        // One is null -> different
        if (p == null || q == null) {
            return false;
        }

        // Values differ -> different
        if (p.val != q.val) {
            return false;
        }

        // Both subtrees must also be identical
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}
