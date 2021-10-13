/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
  if (!root) return [];
  const result = [];
  const recursion = (root, level) => {
    if (result.length === level) result.push([]);
    result[level].push(root.val);
    for (let i = 0; i < root.children.length; i++) {
      recursion(root.children[i], level + 1);
    }
  }
  recursion(root, 0);
  return result;
};
