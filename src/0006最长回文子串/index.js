class Solution {
    longestPalindrome(s) {
        const n = s.length;
        const dp = new Array(n)
            .fill(n)
            .map(_ => new Array(_)
                .fill(false));
        let ans = '';
        for (let l = 0; l < n; l++) {
            for (let i = 0; i < n; i++) {
                const j = i + l;
                if (j >= n) {
                    break;
                } else if (l === 0) {
                    dp[i][j] = true;
                } else if (l === 1) {
                    dp[i][j] = (s[i] === s[j])
                } else {
                    dp[i][j] = (dp[i + 1][j - 1] && s[i] === s[j]);
                }
                if (dp[i][j] && l + 1 > ans.length) {
                    ans = s.slice(i, j + 1);
                }
            }
        }
        return ans;
    }
}


n = 'abcdeedcb';
ins = new Solution();
final1 = ins.longestPalindrome(n);
// final2 = ins.numTrees2(n)
console.log(final1);
