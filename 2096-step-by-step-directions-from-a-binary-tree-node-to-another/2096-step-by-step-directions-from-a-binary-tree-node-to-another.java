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

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();

        // Find paths from root to start and destination nodes
        findPath(root, startValue, startPath);
        findPath(root, destValue, destPath);

        StringBuilder directions = new StringBuilder();
        int commonPathLength = 0;

        // Find the length of the common path
        while (
            commonPathLength < startPath.length() &&
            commonPathLength < destPath.length() &&
            startPath.charAt(commonPathLength) ==
            destPath.charAt(commonPathLength)
        ) {
            commonPathLength++;
        }

        // Add "U" for each step to go up from start to common ancestor
        for (int i = 0; i < startPath.length() - commonPathLength; i++) {
            directions.append("U");
        }

        // Add directions from common ancestor to destination
        for (int i = commonPathLength; i < destPath.length(); i++) {
            directions.append(destPath.charAt(i));
        }

        return directions.toString();
    }

    private boolean findPath(TreeNode node, int target, StringBuilder path) {
        if (node == null) {
            return false;
        }

        if (node.val == target) {
            return true;
        }

        // Try left subtree
        path.append("L");
        if (findPath(node.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1); // Remove last character

        // Try right subtree
        path.append("R");
        if (findPath(node.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1); // Remove last character

        return false;
    }
}