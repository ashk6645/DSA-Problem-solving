class Solution
 






{

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
int count=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    int temp = nums2[j];
                    count=0;
                    while(j<nums2.length-1){
                        j++;
                        if(nums2[j]>temp){
                            nums1[i] = nums2[j];
                            count++;
                            break;
                        }
                        
                    }
                }
            }
            if(count == 0){
                nums1[i] = -1;
            }
        }
        return nums1;

        
    }
}





