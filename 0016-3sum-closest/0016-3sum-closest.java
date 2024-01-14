class Solution {
    public int threeSumClosest(int[] nums, int target) {
     int closestSum = Integer.MAX_VALUE;
     int minDiff = Integer.MAX_VALUE;
     for(int i = 0; i<nums.length-1;i++)
     {
for(int j = i+1;j<nums.length;j++)
{
for(int k = j+1; k<nums.length;k++)
{
int currentSum = nums[i]+nums[j]+nums[k];
int currentDiff = Math.abs(target - currentSum);
if(currentDiff<minDiff)
{
minDiff = currentDiff;
closestSum = currentSum;
}
}
}
}
return closestSum;

        
    }
}