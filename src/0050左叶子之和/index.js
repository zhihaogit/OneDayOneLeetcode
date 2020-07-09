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
var sumOfLeftLeaves = function (root) {
  let sum = 0;
  const recursion = (root, isLeft) => {
    if (!root) return
    if (isLeft && !root.left && !root.right) {
      sum += root.val;
    } else {
      recursion(root.left, true);
      recursion(root.right, false);
    }
  };

  recursion(root, false);
  return sum;
};