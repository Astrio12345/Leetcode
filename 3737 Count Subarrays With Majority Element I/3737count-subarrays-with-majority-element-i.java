class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int totalMajoritySubarrays = 0;
        for (int i = 0; i < n; i++){
            int countOfTarget = 0;
            for (int j = i; j < n; j++){
                int currentLength = j - i + 1;
                if (nums[j] == target){
                    countOfTarget++;
                }
            if (countOfTarget > currentLength / 2){
                totalMajoritySubarrays++;
                }
            }
        }
    return totalMajoritySubarrays;
    }
}