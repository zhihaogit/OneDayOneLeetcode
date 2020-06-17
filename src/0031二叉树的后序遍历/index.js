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
var postorderTraversal = function (root) {
  if (!root) return [];
  const [s, o] = [[root,], []];
  while (s.length) {
    const n = s.pop();
    o.push(n.val);
    n.left && s.push(n.left);
    n.right && s.push(n.right);
  }
  return o.reverse();
};