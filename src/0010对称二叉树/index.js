/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric1 = function (root) {
  const recursionFind = (l, r) => {
    if (!l && !r) {
      return true;
    }
    if (!l || !r) {
      return false;
    }
    if (l.val !== r.val) {
      return false;
    }
    return recursionFind(l.left, r.right) && recursionFind(r.left, l.right);
  }

  return !root
    ? true
    : recursionFind(root.left, root.right);
};


var isSymmetric2 = function (root) {
  if (!root) return true;
  const check = (l, r) => {
    if (!l && !r) {
      return true;
    }
    if (!l || !r) {
      return false;
    }
    if (l.val !== r.val) {
      return false;
    }
    return true;
  }

  const deq = [root.left, root.right];
  while (deq.length) {
    const [l, r] = [deq.shift(), deq.shift];
    if (!check(l, r)) {
      return false;
    }
    l && deq.push(l.left, r.right, r.left, l.right);
  }
  return true;
};
