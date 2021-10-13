/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number[][]}
 */
var pathSum = function (root, sum) {
  if (!root) return [];
  const res = []
  const cursion = (root, tmp, sum) => {
    sum -= root.val;
    !root.left && !root.right && sum === 0 && res.push(tmp);
    root.left && cursion(root.left, [
      ...tmp,
      root.left.val,
    ], sum);
    root.right && cursion(root.right, [
      ...tmp,
      root.right.val,
    ], sum);
  };
  cursion(root, [root.val], sum);
  return res;
};
