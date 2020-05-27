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
var maxDepth1 = function (root) {
  return root
    ? Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1
    : 0
};

var maxDepth2 = function (root) {
  const stack = [];
  if (root) {
    stack.push([1, root])
  }

  let dept = 0;
  while (stack.length) {
    const [currentDept, currentRoot] = stack.shift();
    if (currentRoot) {
      dept = Math.max(dept, currentDept);
      stack.push([currentDept + 1, currentRoot.left]);
      stack.push([currentDept + 1, currentRoot.right]);
    }
  }
  return dept
};