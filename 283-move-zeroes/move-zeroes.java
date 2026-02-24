class Solution {
     public void moveZeroes(int[] nums) {
        int Size = 0; 
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                Size++; 
            }
            else if (Size > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-Size]=t;
            }
        }
    }
}