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
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function (root, k) {
  const stack = [];
  while (true) {
    while (root) {
      stack.push(root);
      root = root.left;
    }
    root = stack.pop();
    k -= 1;
    if (!k) return root.val;
    root = root.right;
  }
};