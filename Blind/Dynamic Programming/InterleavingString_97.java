public class InterleavingString_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int o = s3.length();
        if(m+n != o) return false;
        
        boolean[][] dp = new boolean[m+1][n+1];
        
        dp[0][0] = true;
        
        for(int i=1; i<=m; i++) {
            if (s3.startsWith(s1.substring(0, i))) {
                dp[i][0] = true;
            }
        }
        
        for(int i=1; i<=n; i++) {
            if (s3.startsWith(s2.substring(0, i))) {
                dp[0][i] = true;
            }
        }
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(dp[i-1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    dp[i][j] = true;
                }else if(dp[i][j-1] && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[m][n];
    }
}
