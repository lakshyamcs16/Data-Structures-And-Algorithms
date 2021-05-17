/*

A string s of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts. Example 1: Note: 


*/

/*

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.



*/

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<Integer>();
        
        int i = 0;
        int j = 0;
        int start = 0;
        int n = s.length();
        //bacdef
        while(i<n) {
            int last = s.lastIndexOf(s.charAt(i));
            j = Math.max(j, last);
            
            if(i>=j) {
                ans.add(j - start + 1);
                start = i + 1;
            }
            
            i++;
        }
        
        return ans;
    }
}
​
