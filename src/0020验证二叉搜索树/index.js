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
var isValidBST = function (root) {
  const recursion = (root, left = -Infinity, right = Infinity) => {
    if (!root) return true;
    const val = root.val;
    if (val <= left || val >= right) return false;
    if (!recursion(root.left, left, val)) return false;
    if (!recursion(root.right, val, right)) return false;
    return true;
  };

  return recursion(root);
};