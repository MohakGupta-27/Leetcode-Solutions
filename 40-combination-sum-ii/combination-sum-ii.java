class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, target, candidates, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int index,int remainingTarget,int[] candidates,ArrayList<Integer> current,List<List<Integer>>ans) {

        if (remainingTarget == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (remainingTarget < 0 || index == candidates.length) {
            return;
        }
        current.add(candidates[index]);
        solve(index+1,
              remainingTarget - candidates[index],
              candidates,
              current,
              ans);

        current.remove(current.size() - 1);
        int nextindex = index+1;
        while(nextindex < candidates.length && candidates[nextindex] == candidates[index]){
            nextindex++;
        }
        solve(nextindex,remainingTarget,candidates,current,ans);
    }
}