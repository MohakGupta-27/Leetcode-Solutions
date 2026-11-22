class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int base = 0;
        int satisfied = 0;
        for(int i = 0;i< customers.length;i++){
            if(grumpy[i] == 0){
                base += customers[i];
            }
        }
        for(int i = 0;i < minutes;i++){
            if(grumpy[i] == 1){
                satisfied += customers[i];
            }
            
        }
        int ans = satisfied;
        for(int i = minutes;i<customers.length;i++){
            if(grumpy[i] == 1){
                satisfied += customers[i];
            }
            if(grumpy[i-minutes] == 1){
                satisfied -= customers[i-minutes];
            }
            ans = Math.max(ans,satisfied);
        }
        return ans + base;
    }
}