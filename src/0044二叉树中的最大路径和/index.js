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
var maxPathSum = function (root) {
  let maxSum = -Infinity;
  const maxGain = (root) => {
    if (!root) return 0;
    const leftGain = Math.max(maxGain(root.left), 0);
    const rightGain = Math.max(maxGain(root.right), 0);
    maxSum = Math.max(maxSum, root.val + leftGain + rightGain);
    return root.val + Math.max(leftGain, rightGain);
  };
  maxGain(root);
  return maxSum;
};
