/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number}
 */
var pathSum = function (root, sum) {
  const dfs = (root, sumList) => {
    if (!root) return 0;
    sumList = sumList.map(_ => _ + root.val);
    sumList.push(root.val);
    let count = 0;
    for (let i = 0; i < sumList.length; i++) {
      if (sum === sumList[i]) {
        count += 1;
      }
    }
    return count + dfs(root.left, sumList) + dfs(root.right, sumList);
  };
  return dfs(root, []);
};
