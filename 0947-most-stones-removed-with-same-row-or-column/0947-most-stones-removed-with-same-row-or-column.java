class Solution
{
    private int islands = 0;
    private final Map<Integer, Integer> map = new HashMap<>();

    private int find(int stone) 
    {
        if (!map.containsKey(stone))
        {
            map.put(stone, stone);
            islands++;
        }
        if (map.get(stone) != stone) 
        {
            map.put(stone, find(map.get(stone)));  
        }
        return map.get(stone);
    }

    private void union(int stone1, int stone2)
    {
        int root1 = find(stone1);
        int root2 = find(stone2);
        if (root1 != root2) {
            map.put(root1, root2);  
            islands--;
        }
    }

    public int removeStones(int[][] stones)
    {
        for (int[] stone : stones) {
            union(stone[0], ~stone[1]);
        }
        return stones.length - islands;
    }
    
}