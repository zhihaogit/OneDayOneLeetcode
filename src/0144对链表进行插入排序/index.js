/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var insertionSortList = function (head) {
  if (!head || !head.next) {
    return head;
  }
  const tmpHead = new ListNode(0, head);
  let last = head;
  let curr = head.next;
  while (!!curr) {
    if (last.val <= curr.val) {
      last = last.next;
    } else {
      let first = tmpHead;
      while (first.next.val <= curr.val) {
        first = first.next;
      }
      last.next = curr.next;
      curr.next = first.next;
      first.next = curr;
    }
    curr = last.next;
  }
  return tmpHead.next;
};
