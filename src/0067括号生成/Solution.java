import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class Solution {
  // 暴力法
  public List<String> generateParenthesis1(int n) {
    List<String> combinations = new ArrayList<>();
    generateALl(new char[2 * n], 0, combinations);
    return combinations;
  }

  public void generateALl(char[] current, int pos, List<String> result) {
    if (pos == current.length) {
      if (valid(current)) {
        result.add(new String(current));
      }
    } else {
      current[pos] = '(';
      generateALl(current, pos + 1, result);
      current[pos] = ')';
      generateALl(current, pos + 1, result);
    }
  }

  public boolean valid(char[] current) {
    int bal = 0;
    for (char c : current) {
      if (c == '(') {
        bal++;
      } else {
        bal--;
      }
      if (bal < 0)
        return false;
    }
    return bal == 0;
  }

  // 回溯法
  public List<String> generateParenthesis2(int n) {
    List<String> ans = new ArrayList<>();
    backtrack(ans, new StringBuilder(), 0, 0, n);
    return ans;
  }

  public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
    if (cur.length() == max * 2) {
      ans.add(cur.toString());
      return;
    }
    if (open < max) {
      cur.append('(');
      backtrack(ans, cur, open + 1, close, max);
      cur.deleteCharAt(cur.length() - 1);
    }
    if (close < open) {
      cur.append(')');
      backtrack(ans, cur, open, close + 1, max);
      cur.deleteCharAt(cur.length() - 1);
    }
  }

  // 按括号序列的长度递归
  ArrayList[] cache = new ArrayList[100];

  public List<String> generate(int n) {
    if (cache[n] != null) {
      return cache[n];
    }
    ArrayList<String> ans = new ArrayList<>();
    if (n == 0) {
      ans.add("");
    } else {
      for (int c = 0; c < n; ++c) {
        for (String left : generate(c)) {
          for (String right : generate(n - 1 - c)) {
            ans.add("(" + left + ")" + right);
          }
        }
      }
    }
    cache[n] = ans;
    return ans;
  }

  public List<String> generateParenthesis3(int n) {
    return generate(n);
  }
}
