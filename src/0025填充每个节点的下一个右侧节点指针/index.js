/**
 * // Definition for a Node.
 * function Node(val, left, right, next) {
 *    this.val = val === undefined ? null : val;
 *    this.left = left === undefined ? null : left;
 *    this.right = right === undefined ? null : right;
 *    this.next = next === undefined ? null : next;
 * };
 */

/**
 * @param {Node} root
 * @return {Node}
 */
var connect = function (root) {
  if (!root) return root;
  const deq = [root];
  while (deq.length) {
    const size = deq.length;
    for (let i = 0; i < size; i++) {
      const ele = deq.shift();
      i < size - 1 && (ele.next = deq[0]);
      ele.left && deq.push(ele.left);
      ele.right && deq.push(ele.right);
    }
  }
  return root;
};