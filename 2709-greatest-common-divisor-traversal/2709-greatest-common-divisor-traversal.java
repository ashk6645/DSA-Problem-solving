import java.util.*;
class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
     int n = nums.length;
        Map<Integer, List<Integer>> factorsMap = new HashMap<>();
        
        // Group numbers by their prime factors
        for (int i = 0; i < n; i++) {
            List<Integer> factors = primeFactors(nums[i]);
            for (int factor : factors) {
                factorsMap.putIfAbsent(factor, new ArrayList<>());
                factorsMap.get(factor).add(i);
            }
        }
        
        // Union indices in the same group
        DSU dsu = new DSU(n);
        for (List<Integer> indices : factorsMap.values()) {
            for (int i = 1; i < indices.size(); i++) {
                dsu.union(indices.get(0), indices.get(i));
            }
        }
        
        // Check if all indices belong to the same connected component
        int root = dsu.find(0);
        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != root) {
                return false;
            }
        }
        
        return true;
    }

    private List<Integer> primeFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        if (num > 1) {
            factors.add(num);
        }
        return factors;
    }
    
    class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
}