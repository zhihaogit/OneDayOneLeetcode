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
var levelOrderBottom1 = function (root) {
  result = []
  const recursion = (root, depth) => {
    if (!root) return;
    if (result.length === depth) {
      result.unshift([]);
    }
    result[result.length - depth - 1].push(root.val);
    recursion(root.left, depth + 1);
    recursion(root.right, depth + 1);
  };
  recursion(root, 0);
  return result;
};

var levelOrderBottom2 = function (root) {
  if (!root) return [];
  const result = [];
  const deq = [root];
  while (deq && deq.length) {
    const tmp = [];
    const len = deq.length;
    for (let i = 0; i < len; i++) {
      const node = deq.shift();
      if (node) tmp.push(node.val);
      if (node.left) deq.push(node.left);
      if (node.right) deq.push(node.right);
    }
    result.unshift(tmp);
  }
  return result;
};