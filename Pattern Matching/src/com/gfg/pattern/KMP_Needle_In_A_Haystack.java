class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(m<n) return -1;
        
        int[] ls = buildPrefixArray(needle, n);
        
        return KMP(haystack, needle, m, n, ls);
    }
    
    private int KMP(String str, String ptn, int m, int n, int[] ls) {
        int j = 0;
        int i = 0;
        
        while(j < n && i<m) {
            if (str.charAt(i) == ptn.charAt(j)) {
                i++; j++;
            }else{
                if (j == 0) {
                    i++;
                } else {
                    j = ls[j -1];
                }
            }
        }
        
        return j == n? i - j: -1;
    }
    
    private int[] buildPrefixArray(String ptn, int n) {
        int[] ls = new int[n];
        ls[0] = 0;
        
        int j = 0;
        int i = 1;
        while(i < n) {
            if (ptn.charAt(i) == ptn.charAt(j)) {
                ls[i] = j + 1;
                i++; j++;
            }else{
                if (j == 0) {
                    ls[i] = 0;
                    i++;
                } else {
                    j = ls[j -1];
                }
            }
        }
        
        return ls;
    }
}
