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
  public ListNode swapPairs(ListNode head) {
    if (null == head || null == head.next)
      return head;
    ListNode newHead = head.next;
    head.next = this.swapPairs(newHead.next);
    newHead.next = head;
    return newHead;
  }

  public ListNode swapPairs1(ListNode head) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode temp = dummyHead;
    while (null != temp.next && null != temp.next.next) {
      ListNode node1 = temp.next;
      ListNode node2 = temp.next.next;
      temp.next = node2;
      node1.next = node2.next;
      node2.next = node1;
      temp = node1;
    }
    return dummyHead.next;
  }
}