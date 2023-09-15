//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
         int sum=0;
        for(int a: arr){
            sum+=a;
        }
        if(sum%2!= 0) return 0;
        sum=sum/2;
        int[][] dp= new int[N+1][sum+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return fun(0, arr, sum, N,dp);
    }
    static int fun(int pos, int[] arr, int sum, int n,int[][] dp){
        if(sum==0) return 1;
        if(pos==n || sum<0) return 0;
        if(dp[pos][sum]!= -1){
            return dp[pos][sum];
        }
        return dp[pos][sum]=Math.max(fun(pos+1,arr,sum-arr[pos],n,dp),fun(pos+1,arr,sum,n,dp));
        
    }
}