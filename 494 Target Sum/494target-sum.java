import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target, new HashMap<>());
    }

    private int dfs(int[] nums, int index, int sum, int target, Map<String, Integer> memo) {
        String key = index + "," + sum;
        if (memo.containsKey(key)) return memo.get(key);

        if (index == nums.length) return sum == target ? 1 : 0;

        int plus = dfs(nums, index + 1, sum + nums[index], target, memo);
        int minus = dfs(nums, index + 1, sum - nums[index], target, memo);

        memo.put(key, plus + minus);
        return plus + minus;
    }
}