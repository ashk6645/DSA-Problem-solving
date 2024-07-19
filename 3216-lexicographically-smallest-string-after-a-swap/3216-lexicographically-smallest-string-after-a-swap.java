class Solution 
{
     public static String getSmallestString(String s) 
     {
        char [] a = s.toCharArray();
        char t;

        for(int i=0, l=a.length; i<l-1; i++)
            if(a[i]%2==a[i+1]%2 && a[i]>a[i+1])
            {
                t = a[i];
                a[i] = a[i+1];
                a[i+1] = t;

                break;
            }

        return new String(a);
     }
}
