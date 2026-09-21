class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> current = new ArrayList<>();
        List<List<Integer>> ans =  new ArrayList<>();
        boolean[] found = new boolean[nums.length];
        Arrays.sort(nums);
        solve(nums,current,ans,found);
        return ans;
    }
    private void solve(int[] nums,ArrayList<Integer> current,List<List<Integer>>ans,boolean[] found){
        if(current.size() == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!found[i]){
                found[i] = true;
                current.add(nums[i]);
                solve(nums,current,ans,found);
                current.remove(current.size() - 1);
                found[i] = false;
            }
        }
    }
}