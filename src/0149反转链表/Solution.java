// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

// 示例 1：
// 输入：head = [1,2,3,4,5]
// 输出：[5,4,3,2,1]

// 示例 2：
// 输入：head = [1,2]
// 输出：[2,1]

// 示例 3：
// 输入：head = []
// 输出：[]

// 提示：
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000

// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？

/**
 * Definition for singly-linked list.
 */
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  /**
   * 迭代法
   * 
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode prev = null;
    ListNode current = head;
    while (current != null) {
      // 记录当前节点的指向
      ListNode next = current.next;
      // 更改当前节点的指向到前一个节点
      current.next = prev;
      // 记录的前一个节点更新
      prev = current;
      // 向后迭代
      current = next;
    }
    return prev;
  }

  /**
   * 递归法
   * 将 1 -> 2改为 2 -> 1
   * 
   * @param head
   * @return
   */
  public ListNode reverseList1(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverseList(head.next);
    // 当前节点的下一个节点，指向当前节点
    head.next.next = head;
    // 当前节点不再指向其他节点，避免成环
    head.next = null;
    return newHead;
  }
}
