/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function (root) {
  const nodes = [];
  const recursion = (root) => {
    if (!root) return;
    recursion(root.left);
    nodes.push(root);
    recursion(root.right);
  };
  recursion(root);
  let x = null;
  let y = null;
  const len = nodes.length - 1;
  for (let i = 0; i < len; i++) {
    if (nodes[i + 1].val < nodes[i].val) {
      y = nodes[i + 1];
      if (x) break;
      x = nodes[i];
    }
  }
  x && y && ([x.val, y.val] = [y.val, x.val]);
};
