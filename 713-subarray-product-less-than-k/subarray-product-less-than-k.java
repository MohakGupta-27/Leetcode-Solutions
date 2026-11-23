class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, res = 0;
        int left = 0;
        int product = 1;
        for(int right = 0;right < n;right++){
            product *= nums[right];
            while(product >= k && left <= right){
                product /= nums[left++];
            }
            res += right - left + 1;
        }

        return res;
    }
}