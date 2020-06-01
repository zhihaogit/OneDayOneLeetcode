/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function (root) {
  const check = root => {
    if (!root) return [true, -1];
    const [isLeftBalanced, leftHeight] = check(root.left);
    if (!isLeftBalanced) return [false, 0];
    const [isRightBalanced, rightHeight] = check(root.right);
    if (!isRightBalanced) return [false, 0];
    return [Math.abs(leftHeight, rightHeight), 1 + Math.max(leftHeight, rightHeight)];
  };
  return check(root)[0];
};