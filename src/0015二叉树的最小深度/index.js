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
var minDepth = function (root) {
  if (!root) return 0;
  const leftMin = minDepth(root.left);
  const rightMin = minDepth(root.right);
  const finalMin = leftMin && rightMin
    ? Math.min(leftMin, rightMin)
    : leftMin || rightMin;
  return finalMin + 1;
};
