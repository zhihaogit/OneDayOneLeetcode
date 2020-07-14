/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function (root) {
  const recursion = (root) => {
    if (!root) return 'null';
    const left = recursion(root.left);
    const right = recursion(root.right);
    return root.val + ',' + left + right;
  };
  return recursion(root);
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
  const list = data.split(',');
  const recursion = (l) => {
    const val = l.shift();
    if (val === 'null') return null;
    const node = new TreeNode(val);
    node.left = recursion(l);
    node.right = recursion(l);
    return node;
  };
  return recursion(list);
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */