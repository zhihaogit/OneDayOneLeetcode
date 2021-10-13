/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 */
var BSTIterator = function(root) {
  this.sortNode = [];
  this.index = -1;
  this._inorder(root)
};

BSTIterator.prototype._inorder = function(root) {
  if (!root) return;
  this._inorder(root.left);
  this.sortNode.push(root.val)
  this._inorder(root.right);
};

/**
 * @return the next smallest number
 * @return {number}
 */
BSTIterator.prototype.next = function() {
  this.index += 1;
  return this.sortNode[this.index];
};

/**
 * @return whether we have a next smallest number
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function() {
  return this.index + 1 < this.sortNode.length;
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
