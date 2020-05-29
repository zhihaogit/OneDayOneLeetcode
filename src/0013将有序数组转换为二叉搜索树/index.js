/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function (nums) {
  const cursion = (l, r) => {
    if (l > r) return null;
    const p = ~~((l + r) / 2);
    const root = new TreeNode(nums[p]);
    root.left = cursion(l, p - 1);
    root.right = cursion(p + 1, r);
    return root;
  };
  return cursion(0, nums.length - 1);
};