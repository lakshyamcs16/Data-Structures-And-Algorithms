/*

A message containing letters from A-Z can be encoded into numbers using the following mapping:To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".Given a string s containing only digits, return the number of ways to decode it.The answer is guaranteed to fit in a 32-bit integer. Example 1:Example 2:Example 3:Example 4: Constraints:


*/

/*

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with 0.
The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
Hence, there are no valid ways to decode this since all digits need to be mapped.
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").



*/

class Solution {
    int count = 0;
    //next step: Learn DP and convert to DP
    public int numDecodings(String s) {
        Map<String, Character> map = new HashMap<String, Character>();
        for(int i=1; i<=26; i++) {
            map.put(String.valueOf(i), (char)('A' + (i - 1)));
        }
        
        ways("", "", 0, s, map);
        return count;
    }
    
    private void ways(String sub, String ss, int i, String s, Map<String, Character> map) {
        if(ss.length() > s.length()) {
            return;
        }
​
        if(sub.length()>0 && !map.containsKey(sub)) {
            return;
        }
    
        if(ss.length() == s.length()) {
            count++;
        }
                
        if(i+1 <= s.length()) {
            ways(s.substring(i, i+1), ss + s.substring(i, i+1), i + 1, s, map);
        }
        
        if(i+2 <= s.length()) {
            ways(s.substring(i, i+2), ss + s.substring(i, i+2), i + 2, s, map);
        }
        
    }
}
​
