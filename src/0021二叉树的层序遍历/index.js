/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  if (!root) return [];
  const deq = [];
  const res = [];
  while (deq.length) {
    const vals = [];
    const size = deq.length;
    for (let i = 0; i < size; i++) {
      const node = deq.shift();
      vals.push(node);
      node.left && deq.push(node.left);
      node.right && deq.push(node.right);
    }
    res.push(vals);
  }
  return res;
};