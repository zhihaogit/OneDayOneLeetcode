/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {string[]}
 */
var binaryTreePaths = function (root) {
  const paths = [];
  const recursion = (root, path) => {
    if (!root) return;
    path += root.val;
    !root.left && !root.right && paths.push(path);
    recursion(root.left, path + '->');
    recursion(root.right, path + '->');
  };
  recursion(root, '');
  return paths;
};