/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function(root) {
  const max_dict = {};
  let max_depth =  -1;
  const stack = [[root, 0]]

  while (stack.length) {
    const [node, depth] = stack.shift();
    if (node) {
      max_depth = Math.max(max_depth, depth);
      max_dict[depth] = node.val;
      stack.push(node.left);
      stack.push(node.right);
    }
  }

  const res = [];
  for (let i = 0; i < max_depth + 1; i++) {
    const val = max_dict[i];
    res.push(val);
  }
  return res;
};
