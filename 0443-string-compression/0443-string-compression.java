class Solution
{
    public int compress(char[] chars) 
    {
        int n = chars.length;
        int writeIndex = 0;
        int count = 1;
        for(int i=1;i<n;i++)
        {
            if(chars[i] == chars[i-1])
            {
                count++;
            }
            else
            {
                chars[writeIndex++] = chars[i-1];
                if(count>1)
                {
                    char[] countChars = String.valueOf(count).toCharArray()
;
                for(char c: countChars)
                {
                    chars[writeIndex++] =  c;
                }
                    }
                count = 1;
            }
        }
        
        chars[writeIndex++] = chars[n - 1];
        if (count > 1) {
            char[] countChars = String.valueOf(count).toCharArray();
            for (char c : countChars) {
                chars[writeIndex++] = c;
            }
        }

        return writeIndex;
        
    }
}