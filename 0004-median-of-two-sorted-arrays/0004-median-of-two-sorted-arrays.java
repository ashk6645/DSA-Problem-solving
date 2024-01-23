class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        int arr3[] = new int[n1 + n2];
        mergeArrays(nums1, nums2, n1, n2, arr3);
        int n=arr3.length;
        if(arr3.length%2!=0){
            return arr3[n/2];
        }else{
            return (double)(arr3[n/2]+arr3[n/2-1])/2;
        }

    }
    public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3){
        int i = 0;  
        int j = 0;  
        int k = 0;  
         
        
        while(i < n1){   
         arr3[k++] = arr1[i++];   
        }   
         
        
        while(j < n2){   
         arr3[k++] = arr2[j++];   
        }   
         
        
        Arrays.sort(arr3);
        
        
    }
}