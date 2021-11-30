/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function (head) {
  const headSet = new Set();
  let poi = head;
  while (poi != null) {
    if (headSet.has(poi)) {
      return poi;
    } else {
      headSet.add(poi);
    }
    poi = poi.next;
  }
  return null;
};
