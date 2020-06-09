/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var buildTree = function (inorder, postorder) {
  const indexMap = inorder.reduce((acc, cv, ci) => ({
    ...acc,
    [cv]: ci
  }), {});

  const recursion = (inorderLeft, inorderRight) => {
    if (inorderLeft > inorderRight) return null;
    const val = postorder.pop();
    const index = indexMap[val];
    const root = new TreeNode(val);
    root.right = recursion(index + 1, inorderRight);
    root.left = recursion(inorderLeft, index - 1);
    return root;
  };

  return recursion(0, inorder.length - 1);
};