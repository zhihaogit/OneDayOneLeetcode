/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number} n
 * @return {TreeNode[]}
 */
var generateTrees = function (n) {
  const recursion = (left, right) => {
    if (left > right) return [null];
    const nodes = [];
    for (let i = left; i <= right; i++) {
      const LT = recursion(left, i - 1);
      const RT = recursion(i + 1, right);

      for (const l of LT) {
        for (const r of RT) {
          const root = new TreeNode(i);
          root.left = l;
          root.right = r;
          nodes.push(root);
        }
      }
    }
    return nodes;
  };
  return n ? recursion(1, n) : [];
};
