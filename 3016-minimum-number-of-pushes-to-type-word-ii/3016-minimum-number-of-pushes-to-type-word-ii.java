class Solution
{
public int minimumPushes(String word)
{
        if(word.length()<=8)
        {
            return word.length();
        }
        int[] arr = new int[26];
        for(char ch : word.toCharArray())
        {
            arr[ch-'a']++;
        }
        Arrays.sort(arr);
        reverse(arr);
        
        int cost=0;
        for(int i=0; i<26; i++) 
        {
            if(arr[i]!=0)
            {
                if(i<8) 
                {
                    cost+=1*arr[i];
                } 
                else if(i>=8 && i<16)
                {
                    cost+=2*arr[i];
                } 
                else if(i<24)
                {
                    cost+=3*arr[i];
                }
                else
                {
                    cost+=4*arr[i];
                }
            }
        }
        return cost;
    }

    public static void reverse(int[] array)
    {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) 
        {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }
}