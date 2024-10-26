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
    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> nodeDepths = new HashMap<>();
        Map<Integer, Integer> subtreeHeights = new HashMap<>();
        Map<Integer, Integer> firstLargestHeight = new HashMap<>();
        Map<Integer, Integer> secondLargestHeight = new HashMap<>();
        
        dfs(root, 0, nodeDepths, subtreeHeights, firstLargestHeight, secondLargestHeight);
        
        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryNode = queries[i];
            int nodeLevel = nodeDepths.get(queryNode);
            if (subtreeHeights.get(queryNode).equals(firstLargestHeight.get(nodeLevel))) {
                results[i] = nodeLevel + secondLargestHeight.getOrDefault(nodeLevel, 0) - 1;
            } else {
                results[i] = nodeLevel + firstLargestHeight.getOrDefault(nodeLevel, 0) - 1;
            }
        }
        return results;
    }

    private int dfs(TreeNode node, int level, Map<Integer, Integer> nodeDepths, 
                    Map<Integer, Integer> subtreeHeights, Map<Integer, Integer> firstLargestHeight, 
                    Map<Integer, Integer> secondLargestHeight) {
        if (node == null) return 0;
        
        nodeDepths.put(node.val, level);

        int leftHeight = dfs(node.left, level + 1, nodeDepths, subtreeHeights, firstLargestHeight, secondLargestHeight);
        int rightHeight = dfs(node.right, level + 1, nodeDepths, subtreeHeights, firstLargestHeight, secondLargestHeight);
        
        int currentHeight = 1 + Math.max(leftHeight, rightHeight);
        subtreeHeights.put(node.val, currentHeight);

        int currentFirstLargest = firstLargestHeight.getOrDefault(level, 0);
        if (currentHeight > currentFirstLargest) {
            secondLargestHeight.put(level, currentFirstLargest);
            firstLargestHeight.put(level, currentHeight);
        } else if (currentHeight > secondLargestHeight.getOrDefault(level, 0)) {
            secondLargestHeight.put(level, currentHeight);
        }

        return currentHeight;
        
        
    }
}