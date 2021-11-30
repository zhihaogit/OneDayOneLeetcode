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
var sortList = function (head) {
  return mergeSort(head, null);
};

var mergeSort = function (head, tail) {
  if (!head) {
    return head;
  }
  if (head.next === tail) {
    head.next = null;
    return head;
  }
  let slow = head;
  let fast = head;
  while (fast !== tail) {
    slow = slow.next;
    fast = fast.next;
    if (fast !== tail) {
      fast = fast.next;
    }
  }

  const mid = slow;
  return merge(mergeSort(head, mid), mergeSort(mid, tail));

}

var merge = (A, B) => {
  const tmpHead = new ListNode(0);
  let tmpNode = tmpHead;
  while (!!A && !!B) {
    if (A.val < B.val) {
      tmpNode.next = A;
      A = A.next;
    } else {
      tmpNode.next = B;
      B = B.next;
    }
    tmpNode = tmpNode.next;
  }

  if (!A) {
    tmpNode.next = B;
  } else if (!B) {
    tmpNode.next = A;
  }

  return tmpHead.next;
};
