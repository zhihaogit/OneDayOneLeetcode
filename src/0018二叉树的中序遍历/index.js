/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function (root) {
  if (!root) return [];
  const deq = [[1, root]];
  const res = [];
  while (deq && deq.length) {
    const [s, n] = deq.pop();
    if (!n) continue;
    if (s) {
      deq.push([1, n.right]);
      deq.push([0, n]);
      deq.push([1, n.left]);
    } else {
      res.push(n.val);
    }
  }
  return res;
};