import java.util.*;
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int i = 0;i < weights.length; i++){
            low = Math.max(weights[i],low);
            high += weights[i];
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canship(weights,mid) > days){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return low;
    }
    public int canship(int[] weights,int capacity){
        int day = 1;
        int load = 0;
        for(int i =0;i < weights.length;i++){
            if(weights[i] + load > capacity){
                day = day+1;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return day;
    }
}