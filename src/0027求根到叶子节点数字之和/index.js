/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function (root) {
  if (!root) return 0;
  const recursion = (root, sum) => {
    const val = sum * 10 + root.val;
    if (!root.left && !root.right) return val;
    const lv = root.left
      ? recursion(root.left, val)
      : 0;
    const rv = root.right
      ? recursion(root.right, val)
      : 0;
    return lv + rv;
  };
  return recursion(root, 0);
};