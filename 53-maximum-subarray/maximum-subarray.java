class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = (left + right) / 2;

        int leftMax = helper(nums, left, mid);
        int rightMax = helper(nums, mid + 1, right);

        int leftSum = Integer.MIN_VALUE, sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        int crossSum = leftSum + rightSum;

        return Math.max(Math.max(leftMax, rightMax), crossSum);
    }
}
