
/**
 * Definition for a binary tree node.
 */
function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
class Solution {
  buildTree(preorder, inorder) {
    const index = inorder.reduce((acc, cv, ci) => ({
      ...acc,
      [cv]: ci
    }), {});
    const myBuildTree = (preorderLeft, preorderRight, inorderLeft, inorderRight) => {
      if (preorderLeft > preorderRight) return null;
      const preorderRoot = preorderLeft;
      const inorderRoot = index[preorder[preorderRoot]];
      const root = new TreeNode(preorder[preorderRoot]);
      const sizeLeftSubtree = inorderRoot - inorderLeft;
      root.left = myBuildTree(preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft, inorderRoot - 1);
      root.right = myBuildTree(preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1, inorderRight);
      return root;
    }

    const n = preorder.length;
    return myBuildTree(0, n - 1, 0, n - 1);
  }
}

preorder = [3, 9, 20, 15, 7]
inorder = [9, 3, 15, 20, 7]
ins = new Solution()
final1 = ins.buildTree(preorder, inorder)
console.log(final1)
    