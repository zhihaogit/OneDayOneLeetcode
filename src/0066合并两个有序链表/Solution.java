/**
 * Definition for singly-linked list.
 * 
 */
public class ListNode {
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
  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      l1.next = mergeTwoLists1(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists1(l1, l2.next);
      return l2;
    }
  }

  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    ListNode prehead = new ListNode(-1);
    ListNode pre = prehead;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        pre.next = l1;
        l1 = l1.next;
      } else {
        pre.next = l2;
        l2 = l2.next;
      }
      pre = pre.next;
    }
    pre.next = l1 == null ? l2 : l1;
    return prehead.next;
  }
}
