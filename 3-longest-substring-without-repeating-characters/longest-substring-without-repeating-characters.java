class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i =0,e=0;
        Set<Character> seen = new HashSet<>();
        int maxLen = 0;
        while(e<n){
            char c = s.charAt(e);
            while(seen.contains(c)){
                seen.remove(s.charAt(i));
                i++;
            }
            seen.add(c);
            e++;
            maxLen = Math.max(maxLen,e-i);
        }
        return maxLen;
    }
}