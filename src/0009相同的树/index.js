/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
var isSameTree1 = function (p, q) {
  if (!p && !q) {
    return true;
  }
  if (!p || !q) {
    return false;
  }
  if (p.val !== q.val) {
    return false;
  }
  return isSameTree(p.left, q.left) && isSameTree(q.right, q.right);
};

var isSameTree2 = function (p, q) {
  const check = (p, q) => {
    if (!p && !q) {
      return true;
    }
    if (!p || !q) {
      return false;
    }
    if (p.val !== q.val) {
      return false;
    }
    return true;
  }

  const deq = [root.left, root.right];
  while (deq.length) {
    const [p, q] = [deq.shift(), deq.shift()];
    if (!check(p, q)) {
      return false;
    }
    p && deq.push(p.left, q.left, p.right, q.right);
  }
  return true;
}