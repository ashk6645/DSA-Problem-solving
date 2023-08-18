class Solution 
{
     public static int findKthLargest(int[] arr, int k) 
 {
   PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
     for (int i = 0; i < k; i++)
      {
        pq.add(arr[i]);
      }
    

    for (int i = k; i < arr.length; i++) 
    {
        if (arr[i] > pq.peek())
         {
            pq.poll();
            pq.add(arr[i]);
        }
    }
    

    return pq.peek();
 }

        
}
