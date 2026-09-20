class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        solve(0,current,ans,nums);
        return ans;
    }

    private void solve(int index,List<Integer> current,List<List<Integer>> ans,int[] nums){
        if(index == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        solve(index+1,current,ans,nums);
        current.remove(current.size()-1);
        int next = index+1;
        while(next < nums.length && nums[index] == nums[next]){
            next++;
        }
        solve(next,current,ans,nums);
    }
}