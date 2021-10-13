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
var preorderTraversal = function (root) {
  if (!root) return [];
  const [stack, output] = [[root], []];
  while (stack.length) {
    node = stack.pop();
    output.push(node.val);
    node.right && stack.push(node.right);
    node.left && stack.push(node.left);
  }
  return output;
};
