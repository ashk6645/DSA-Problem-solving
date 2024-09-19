class Solution 
{
    public String countAndSay(int n)
    {
        String str = "1";
    for(int i = 2; i <= n; i++) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int j = 0; j < str.length(); j++) {
            if(j < str.length() - 1 && str.charAt(j) == str.charAt(j+1)) {
                count++;
            } else {
                sb.append(count).append(str.charAt(j));
                count = 1;
            }
        }
        str = sb.toString();
    }
    return str;
}
       
}