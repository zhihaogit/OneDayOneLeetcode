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
  const find = (child, prev, leftmost) => {
    if (child) {
      if (prev) {
        prev.next = child;
      } else {
        leftmost = child;
      }
      prev = child;
    }
    return [prev, leftmost];
  };

  let leftmost = root;
  while (leftmost) {
    let [prev, curr] = [null, leftmost];
    leftmost = null
    while (curr) {
      [prev, leftmost] = find(curr.left, prev, leftmost);
      [prev, leftmost] = find(curr.right, prev, leftmost);
      curr = curr.next;
    }
  }
  return root;
};
