/**
 * @param {string} s
 * @return {number}
 */
 var lengthOfLongestSubstring = function(s) {
    const set = new Set();
    let max = 0;
    for(let i=0, j=0; i<s.length; i++) {
        if(set.has(s[i])) {
            while(j<s.length && s[j] !== s[i]) {
                set.delete(s[j]);
                j++;
            }
            j++;
        }else{
            set.add(s[i]);
            max = Math.max(max, i - j + 1);
        }
    }
    
    return max;
};