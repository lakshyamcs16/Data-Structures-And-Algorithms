/**
 * @param {string} s
 * @return {string}
 */
 var longestPalindrome = function(s) {
    let n = s.length;
    let max = 1;
    let index = 0;

    if (n <= 1) return s[0];

    const dp = new Array(n).fill().map(item => new Array(n).fill(false));
    
    for(let i=0; i<n; i++) {
        dp[i][i] = true;
    }

    for(let i=1; i<n; i++) {
        if (s[i] === s[i-1]) {
            dp[i-1][i] = true;
            max = 2;
            index = i;
        }
    }

    for(let i=3; i<=n; i++) {
        for(let j=0; j<n-i+1; j++) {
            let k = i + j - 1;
            
            if(s[k] === s[j] && dp[j+1][k-1]) {
                dp[j][k] = true;
                if (max < i) {
                    max = i;
                    index = k;
                }
            }
        }
    }

    // console.log(index, max);
    return s.substring(index - max + 1, index + 1);
};

function TestCode(tests = []) {
    for(let test of tests) {
        console.log(longestPalindrome(test));
    }
}

TestCode(["ababa", "babad", "cbbd", "ccc", "a", "ab", "aa", "nitin", "abcsdffgsfawertertrtyjhnbfvdfghfgbvxdfsdhfgbvxfsdffvcvbngnghfdtgfsdfsgryurytdtfsdfdfgjghgfdgfd"])
// ababa
// bab
// bb
// ccc
// a
// a
// aa
// nitin
// rtr