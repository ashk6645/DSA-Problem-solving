class Solution 
{

    public int[] sortArray(int[] nums)
    {
        mergeSort(nums,0,nums.length-1);
        return nums;
        
    }

    public void merge (int[] nums,int start,int middle,int end){
      int n1=middle-start+1;
      int n2= end-middle;
      int arr1[]=new int[n1];
      int arr2[]=new int[n2];
      for(int i=0;i<n1;i++){
         arr1[i]=nums[start+i];
      }
      for(int i=0;i<n2;i++){
        arr2[i]=nums[middle+1+i];
      }
      int i=0;
      int j=0;
      int k=start;
      while(i<n1 && j<n2){
        if(arr1[i]<=arr2[j]){
            nums[k++]=arr1[i++];
        }else{
            nums[k++]=arr2[j++];
        }
      }
      while(i<n1){
        nums[k++]=arr1[i++];
      }
      while(j<n2){
        nums[k++]=arr2[j++];
      }
    }
    public void mergeSort (int[] nums,int start,int end){
        if(start<end){
        int middle=start+(end-start)/2;
        mergeSort(nums,start,middle);
        mergeSort(nums,middle+1,end);
        merge(nums,start,middle,end);
        }
    }
}