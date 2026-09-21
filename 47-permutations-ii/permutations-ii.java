class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; 
        Arrays.sort(nums);
        solve(nums,current,result,used);
        return result;
    }
    private void solve(int[] nums,List<Integer> current, List<List<Integer>> result,boolean[] used){
        if (current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1])continue;
            used[i] = true;
            current.add(nums[i]);
            solve(nums,current,result,used);
            current.remove(current.size()-1);
            used[i] = false;
        }
    }
}