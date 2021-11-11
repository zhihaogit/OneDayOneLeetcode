import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定 s 是否可以由空格拆分为一个或多个在字典中出现的单词。
// 说明：拆分时可以重复使用字典中的单词。

// 示例 1：
// 输入: s = "leetcode", wordDict = ["leet", "code"]
// 输出: true
// 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

// 示例 2：
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
// 输出: true
// 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//      注意你可以重复使用字典中的单词。

// 示例 3：
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// 输出: false

// 提示：
// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s 和 wordDict[i] 仅有小写英文字母组成
// wordDict 中的所有字符串 互不相同

class Solution {
  /**
   * 动态规划
   * 
   * 动态转移方程：f[i] = f[j] && check(string[j, i])
   * 
   * 当前位置是否合法，取决于前面的字符串是否合法，截止到当前位置的字符串是否存在与字典中
   * 
   * @param s
   * @param wordDict
   * @return
   */
  public boolean wordBreak(String s, List<String> wordDict) {
    // 将 List转为 set集合
    Set<String> wordSet = new HashSet<String>(wordDict);
    int n = s.length();
    // 记录每一个位置是否合法
    boolean[] dp = new boolean[n + 1];
    // 边界情况，设置第一个为空串，且合法
    dp[0] = true;
    for (int i = 1; i <= n; i++) {
      // 从前往后枚举
      for (int j = 0; j < i; j++) {
        // 如果前面的字符串合法，并且 set中存在该段字符串，当前位置也合法
        if (dp[j] && wordSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }
}
