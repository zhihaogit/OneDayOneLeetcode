/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function (candidates, target) {
  const len = candidates.length;
  const ans = [];
  if (!len) {
    return ans;
  }
  const combine = [];
  // 回溯的前提是排序数组
  dfs(candidates.sort((a, b) => a - b), target, ans, combine, len, 0);
  return ans;
};

// 回溯加剪枝
var dfs = (candidates, target, ans, combine, len, index) => {
  if (!target) {
    ans.push(combine);
    return;
  }
  for (let i = index; i < len; i++) {
    if (target - candidates[i] < 0) {
      break;
    }
    dfs(candidates, target - candidates[i], ans, [...combine, candidates[i]], len, i);
  }
};

const p1 = [3, 12, 9, 11, 6, 7, 8, 5, 4];
const p2 = 15;
console.log(combinationSum(p1, p2));
