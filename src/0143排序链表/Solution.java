// 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

// 进阶：
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

// 示例 1：
// 输入：head = [4,2,1,3]
// 输出：[1,2,3,4]

// 示例 2：
// 输入：head = [-1,5,3,4,0]
// 输出：[-1,0,3,4,5]

// 示例 3：
// 输入：head = []
// 输出：[]

// 提示：
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105

/**  if (!head) {
    return head;
  }
  if (head.next === tail) {}

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
   * 归并排序（自底向上，迭代）
   * 
   * @param head
   * @return
   */
  public ListNode sortList(ListNode head) {
    if (head == null) {
      return head;
    }

    // 1. 统计链表的总长度
    int len = 0;
    ListNode node = head;
    while (node != null) {
      len++;
      node = node.next;
    }

    // 2. 初始化起始的模板节点
    ListNode tmpHead = new ListNode(0);
    tmpHead.next = head;

    // 3. subLen从 1开始，拆分两两链表，再合并成 2倍 subLen长度的链表
    for (int subLen = 1; subLen < len; subLen <<= 1) {
      // 本次循环的前置节点
      ListNode prev = tmpHead;
      // 本次循环的当前节点
      ListNode curr = tmpHead.next;

      // 3-1. 每拆分并合并两个子链表后，切换 curr节点
      while (curr != null) {
        // 3-2. 拆分出第一个 subLen长度的链表
        ListNode head1 = curr;
        for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
          curr = curr.next;
        }

        // 3-3. 拆分出第二个 subLen长度的链表
        ListNode head2 = curr.next;
        // 清除第一个链表与后续链表的连接
        curr.next = null;
        curr = head2;
        for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
          curr = curr.next;
        }

        // 3-4. 记录第二个链表与后续链表的终止点，并清除第二个链表与后续链表的连接
        ListNode next = null;
        if (curr != null) {
          next = curr.next;
          curr.next = null;
        }

        // 3-5. 合并两个子链表
        ListNode merged = merge(head1, head2);
        // 重置 prev的节点位置
        prev.next = merged;
        while (prev.next != null) {
          prev = prev.next;
        }
        // 3-6. 重置 curr的节点位置，进入下次拆分合并两个子链表
        curr = next;
      }
    }

    // 返回排序后的子链表
    return tmpHead.next;

    // 为过测试用例，自顶向下调用
    // return sortList(head, null);
  }

  /**
   * 归并排序（自顶向下，递归）
   * 
   * @param head
   * @param tail
   * @return
   */
  public ListNode sortList(ListNode head, ListNode tail) {
    if (head == null) {
      return head;
    }
    if (head.next == tail) {
      head.next = null;
      return head;
    }
    // 使用快慢指针寻找中间节点
    // 原理为快指针的步数是慢指针的 2倍，当快指针到末尾的时候，慢指针的位置刚好是中间位置
    ListNode slow = head;
    ListNode fast = head;
    while (fast != tail) {
      slow = slow.next;
      fast = fast.next;
      if (fast != tail) {
        fast = fast.next;
      }
    }
    ListNode mid = slow;
    ListNode left = sortList(head, mid);
    ListNode right = sortList(mid, tail);
    return merge(left, right);
  }

  /**
   * 合并两个节点
   * 
   * AB节点不断查找 next的同时，比较两者的 val，较小值的节点将作为模板节点的 next节点
   * 
   * @param A
   * @param B
   * @return
   */
  public ListNode merge(ListNode A, ListNode B) {
    // 初始化链表的起始模板节点
    ListNode headTmp = new ListNode(0);
    // 初始化替代节点，需要不断更新替代节点
    ListNode nodeTmp = headTmp;

    while (A != null && B != null) {
      if (A.val < B.val) {
        nodeTmp.next = A;
        A = A.next;
      } else {
        nodeTmp.next = B;
        B = B.next;
      }
      nodeTmp = nodeTmp.next;
    }

    // 退出循环的条件是有一个节点不存在，所以需要把依旧存在的节点连接到模板节点上
    if (A != null) {
      nodeTmp.next = A;
    } else if (B != null) {
      nodeTmp.next = B;
    }
    return headTmp.next;
  }
}
