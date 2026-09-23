class Solution {
    public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1) return nums[0];
    if (n == 2) return Math.max(nums[0], nums[1]);

    int excludeLast = robLinear(nums, 0, n - 2);
    int excludeFirst = robLinear(nums, 1, n - 1);

    return Math.max(excludeLast, excludeFirst);
}

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
