/*

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. Example 1:Example 2: Constraints:


*/

/*

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".



*/

/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function(s, p) {
    const m = s.length;
    const n = p.length;
    debugger
    const res = [];
​
    if(n > m) return res;
        
    const pc = freq(p);
    const sc = freq(s.substring(0, n));
    
    if(areSame(pc, sc)) {
        res.push(0);
    }
    
    for(let i=n; i<m; i++) {
        sc[s.charCodeAt(i - n) - 97]--;
        sc[s.charCodeAt(i) - 97]++;
        if(areSame(pc, sc)) {
            res.push(i-n+1);
        }
    }
    
    return res;
};
​
function freq(str) {
    const count = new Array(26).fill(0);
    for(let i=0; i<str.length; i++) {
        count[str.charCodeAt(i) - 97]++;
    }
    return count;
}
​
function areSame(pc, sc) {
    for(let i=0; i<26; i++) {
        if(pc[i] !== sc[i]) return false;
    }
    return true;
}
​
