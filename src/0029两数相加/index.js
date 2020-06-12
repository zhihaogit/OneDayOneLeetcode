/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
  let dummy = p = new ListNode(Null);
  let s = 0;
  while (l1 || l2 || s) {
    s += (l1 ? l1.val : 0) + (l2 ? l2.val : 0);
    p.next = new ListNode(s % 10);
    p = p.next;
    s = parseInt(s / 10);
    l1 = l1 ? l1.next : null;
    l2 = l2 ? l2.next : null;
  }
  return dummy.next;
};