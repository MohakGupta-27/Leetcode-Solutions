class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<Integer> current = new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();
        solve(1,n,k,current,ans);
        return ans;

    }
    private void solve(int index,int remainingTarget,int k,ArrayList<Integer> current,List<List<Integer>>ans) {
        if(current.size() == k){
            if(remainingTarget == 0)
                ans.add(new ArrayList<>(current));
                return;
            }

        if (remainingTarget < 0 || index > 9) {
            return;
        }
        current.add(index);
        solve(index+1,remainingTarget - index,k,current,ans);
        current.remove(current.size() - 1);
        solve(index+1,remainingTarget,k,current,ans);


    }
}