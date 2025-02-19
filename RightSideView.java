// Time Complexity: O(n) where n is the number of nodes in the tree
// Space Complexity: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: We will perform a DFS traversal of the tree and keep track of the level of the tree. We will add the rightmost element of each level to the result list.


import java.util.List;

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
class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int level){
        if(root == null){
            return;
        }

        if(res.size() == level){
            res.add(root.val);
        }

        dfs(root.right, res, level+1);
        dfs(root.left, res, level+1);
    }
}
