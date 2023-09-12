class Solution
{
    public boolean isValid(String s)
    {
        Stack<Character> Stack = new Stack<Character>();
        for(char c : s.toCharArray())
        {
            if(c == '(')
            {
                Stack.push(')');
            }
            else if(c == '[')
            {
                Stack.push(']');
            }
            else if(c == '{')
            {
                Stack.push('}');
            }
            else if(Stack.isEmpty() || Stack.pop() != c)
            {
                return false;
            }
        }
            return Stack.isEmpty();

    }
 
}