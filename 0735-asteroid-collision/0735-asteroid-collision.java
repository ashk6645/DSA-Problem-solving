class Solution
{
    public int[] asteroidCollision(int[] asteroids)
    {
          Deque<Integer> stack = new ArrayDeque<>();
        
        for (int asteroid : asteroids) {
            collision:
            {
                while (!stack.isEmpty() && asteroid < 0 && stack.peekLast() > 0) {
                    if (stack.peekLast() < -asteroid) {
                        stack.pollLast();
                        continue;
                    } else if (stack.peekLast() == -asteroid) {
                        stack.pollLast();
                    }
                    break collision;
                }
                stack.addLast(asteroid);
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pollFirst();
        }
        
        return result;
    }
}