// 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

// 示例 1:
// 输入: num1 = "2", num2 = "3"
// 输出: "6"

// 示例 2:
// 输入: num1 = "123", num2 = "456"
// 输出: "56088"

// 说明：
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

class Solution {
  public String multiply(String num1, String num2) {
    if ("0".equals(num1) || "0".equals(num2)) {
      return "0";
    }
    int n1 = num1.length();
    int n2 = num2.length();
    int[] ans = new int[n1 + n2];
    // 字符串每个位置的值相乘，并填入数组对应位置
    for (int i = n1 - 1; i >= 0; i--) {
      int c1 = num1.charAt(i) - '0';
      for (int j = n2 - 1; j >= 0; j--) {
        int c2 = num2.charAt(j) - '0';
        ans[i + j + 1] += c1 * c2;
      }
    }

    // 数组位置进行补位计算
    for (int i = n1 + n2 - 1; i > 0; i--) {
      ans[i - 1] += ans[i] / 10;
      ans[i] %= 10;
    }

    // 如果数组的第一位是 0，则从第二个值开始组合
    int index = ans[0] == 0 ? 1 : 0;
    StringBuffer res = new StringBuffer();
    while (index < n1 + n2) {
      res.append(ans[index]);
      index++;
    }
    return res.toString();
  }
}
