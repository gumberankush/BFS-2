// Time Complexity: O(n) where n is the number of nodes in the tree
// Space Complexity: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : No

// Approach: We will perform a BFS traversal of the tree and keep track of the parent of the nodes x and y. If the parent of x and y are not the same, then they are cousins. We will keep track of the parent of the nodes using two queues. One queue will store the nodes and the other queue will store the parent of the nodes. We will keep track of the parent of the nodes by adding the parent node to the queueP when we add the left or right child of the node to the queue. We will check if the parent of x and y are not the same and return true if they are cousins. If we find x or y, we will return false as we have not found both x and y at the same level. If we do not find x and y at the same level, we will return false.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CousinsBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queueP = new LinkedList<>();

        boolean xFound = false;
        boolean yFound = false;

        TreeNode xParent = null;
        TreeNode yParent = null;

        queue.add(root);
        queueP.add(null);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                TreeNode nodeP = queueP.poll();

                if(node.val == x){
                    xFound = true;
                    xParent = nodeP;
                }

                if(node.val == y){
                    yFound = true;
                    yParent = nodeP;
                }

                if(node.left != null){
                    queue.add(node.left);
                    queueP.add(node);
                }

                if(node.right != null){
                    queue.add(node.right);
                    queueP.add(node);
                }
            }

            if(xFound && yFound){
                if(xParent.val != yParent.val){
                    return true;
                }
            }

            if(xFound || yFound){
                return false;
            }
        }
        return false;
    }
}
