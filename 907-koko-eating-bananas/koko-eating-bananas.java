class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int max= Integer.MIN_VALUE;
        int right = 0;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        int result = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(canFinish(piles,h,mid)){
                result = mid;
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }
        return result;
    }
    public boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours +=(int) Math.ceil((double)pile / k);
            //if (pile % k != 0) hours++;
        }
        return hours <= h;
    }
}