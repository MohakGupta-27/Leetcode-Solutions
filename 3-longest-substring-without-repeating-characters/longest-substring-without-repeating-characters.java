class Solution {
    public int lengthOfLongestSubstring(String s) {

        boolean[] seen = new boolean[128];

        int left = 0;
        int maxlen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            while (seen[ch]) {
                seen[s.charAt(left)] = false;
                left++;
            }

            seen[ch] = true;

            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;
    }
}