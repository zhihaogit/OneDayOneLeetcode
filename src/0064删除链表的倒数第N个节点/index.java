/**
 * Definition for singly-linked list.
 */
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

class Solution {
  /**
   * 两次遍历
   * 
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd1(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int len = 0;
    ListNode first = head;
    while (first != null) {
      len++;
      first = first.next;
    }
    len -= n;
    first = dummy;
    while (len > 0) {
      len--;
      first = first.next;
    }
    first.next = first.next.next;
    return dummy.next;
  }

  /**
   * 一次遍历
   * 双指针，first和 second永远保持 n个距离
   * 
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd2(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    for (int i = 0; i < n + 1; i++) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
  }
}