class Solution {
    public int minDays(int[] bloomday, int m, int k) {
        if ((long)m * k > bloomday.length) return -1;
        //int ans = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i  = 0;i < bloomday.length;i++){
            min = Math.min(min,bloomday[i]);
            max = Math.max(max,bloomday[i]);
        }
        while (min < max){
            int mid = min + (max - min) / 2;
            if(hasflowers(bloomday,m,k,mid)){
                //ans = mid;
                max = mid;
            }
            else{
                min = mid + 1;
            }
        }
        return min;
    }
    public boolean hasflowers(int[] bloomday,int m,int k,int mid){
        int count = 0;
        int bouquee = 0;
        for(int i = 0;i < bloomday.length;i++){
            if(bloomday[i] <= mid){
                count++;
                if(count == k){
                    bouquee++;
                    count = 0;
                }
            
            }
            else{
                count  = 0;
            }
        }
        return bouquee >= m;
    }
}