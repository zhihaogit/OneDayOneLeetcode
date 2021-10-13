/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function (root, p, q) {
  const pVal = p.val;
  const qVal = q.val;
  let node = root;
  while (node) {
    const parentVal = node.val;
    if (pVal > parentVal && qVal > parentVal) {
      node = node.right;
    } else if (pVal < parentVal && qVal < parentVal) {
      node = node.left;
    } else {
      return node;
    }
  }
};
