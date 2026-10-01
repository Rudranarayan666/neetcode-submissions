

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // Empty tree
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            // Process all nodes of current level
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                level.add(node.val);

                // Add left child
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // Add right child
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}