class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int maxlen = 0;
        int maxfreq=  0;
        for(int right  = 0;right < s.length();right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0) + 1);
            maxfreq = Math.max(maxfreq,map.get(ch));
            while((right - left + 1) - maxfreq > k ){
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0) - 1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            maxlen = Math.max(maxlen,right - left + 1);
        }
        return maxlen;
        
        
    }
}