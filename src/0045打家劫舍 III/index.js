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
var rob = function (root) {
  const dfs = (root) => {
    if (!root) return [0, 0];
    const l = dfs(root.left);
    const r = dfs(root.right);
    return [Math.max(...l) + Math.max(...r), root.val + l[0] + r[0]];
  };
  return Math.max(...dfs(root));
};
