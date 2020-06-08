/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var zigzagLevelOrder = function (root) {
  if (!root) return [];
  const res = [];
  const deq = [root];
  let count = 0;
  while (deq.length) {
    count += 1;
    const reverserFlag = count % 2;
    const vals = [];
    const size = deq.length;
    for (let i = 0; i < size; i++) {
      const node = deq.shift();
      reverserFlag
        ? vals.push(node.val)
        : vals.unshift(node.val);
      node.left && deq.push(node.left);
      node.right && deq.push(node.right);
    }
    res.push(vals);
  }
  return res;
};