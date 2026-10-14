class Solution {
public:
typedef long long ll;
    long long maximumSubarraySum(vector<int>& nums, int k) {
        
        int n = nums.size();

        int i=0,j=0;

        unordered_map<int,int> mp;
        ll sum =0;
        ll maxi=0;

        while(j<n){

            int curr = nums[j];

            while(j-i+1>k || mp[curr]){
                sum-=nums[i];
                mp[nums[i]]--;
                ++i;
            }

            mp[curr]++;
            sum+=curr;

            if(j-i+1==k) maxi=max(maxi,sum);
            ++j;
        }

        return maxi;
    }
};