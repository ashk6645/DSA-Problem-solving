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
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
Deque<TreeNode> levelQue = new ArrayDeque<>();
levelQue.offerLast(root);
int level = 0;
while (!levelQue.isEmpty()) {
    int currLevelSize = levelQue.size();
    int prevNodeVal = (level % 2 == 0) ? 0 : 1000001;
    while (currLevelSize-- > 0) {
        TreeNode currNode = levelQue.pollFirst();
        int currNodeVal = currNode.val;
        // Check for even-odd binary tree conditions
        if ((level % 2 == 0 && (prevNodeVal >= currNodeVal || currNodeVal % 2 == 0)) ||
            (level % 2 != 0 && (prevNodeVal <= currNodeVal || currNodeVal % 2 == 1))) {
            return false;
        }
        prevNodeVal = currNodeVal;
        if (currNode.left != null) levelQue.offerLast(currNode.left);
        if (currNode.right != null) levelQue.offerLast(currNode.right);
    }
    level++;
}
return true;

        
    }
}