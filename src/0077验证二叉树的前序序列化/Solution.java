import java.util.Deque;
import java.util.LinkedList;

// 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。

//      _9_
//     /   \
//    3     2
//   / \   / \
//  4   1  #  6
// / \ / \   / \
// # # # #   # #
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。

// 示例 1:
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
// 输出: true

// 示例 2:
// 输入: "1,#"
// 输出: false

// 示例 3:
// 输入: "9,#,#,1"
// 输出: false

class Solution {
  /**
   * 栈
   * 
   * 如果遇到了空节点，则要消耗一个槽位； 如果遇到了非空节点，则除了消耗一个槽位外，还要再补充两个槽位。 最后查看栈是否刚好为空
   */
  public boolean isValidSerialization1(String preorder) {
    int n = preorder.length();
    int i = 0;
    Deque<Integer> stack = new LinkedList<>();
    stack.push(1);
    while (i < n) {
      // 循环中途，栈被清空，则不是完整的树
      if (stack.isEmpty()) {
        return false;
      }
      if (preorder.charAt(i) == ',') {
        i++;
      } else if (preorder.charAt(i) == '#') {
        // 遇到 #，即空节点，消耗一个槽位，将栈顶元素 - 1
        int top = stack.pop() - 1;
        if (top > 0) {
          stack.push(top);
        }
        i++;
      } else {
        // 遇到一个数字，数字可能是多位数，循环至多位数结束
        while (i < n && preorder.charAt(i) != ',') {
          i++;
        }
        // 消耗一个槽位，栈顶元素 - 1
        int top = stack.pop() - 1;
        if (top > 0) {
          stack.push(top);
        }
        // 向栈推入 2个槽位
        stack.push(2);
      }
    }
    // 栈为空，则说明槽位清空，树还原成功
    return stack.isEmpty();
  }

  /**
   * 计数
   * 
   * 将栈视为一个整体，通过计数法直接查看是否可还原
   */
  public boolean isValidSerialization2(String preorder) {
    int n = preorder.length();
    int i = 0;
    int count = 1;
    while (i < n) {
      // 循环过程中，计数值为 0，则无法还原
      if (count == 0) {
        return false;
      }
      if (preorder.charAt(i) == ',') {
        i++;
      } else if (preorder.charAt(i) == '#') {
        count--;
        i++;
      } else {
        while (i < n && preorder.charAt(i) != ',') {
          i++;
        }
        count++;
      }
    }
    return count == 0;
  }
}
