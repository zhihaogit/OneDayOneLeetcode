/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function (candidates, target) {
  const ans = [];
  const len = candidates.length;
  if (!len) {
    return ans;
  }
  const combine = [];
  const newCandidates = candidates.sort((a, b) => a - b);
  dfs(newCandidates, ans, combine, target, len, 0);
  return ans;
};

var dfs = function (candidates, ans, combine, target, len, index) {
  if (!target) {
    ans.push(combine);
  }

  for (let i = index; i < len; i++) {
    if (target - candidates[i] < 0) {
      break;
    }

    if (i > index && candidates[i] === candidates[i - 1]) {
      continue;
    }

    dfs(candidates, ans, [...combine, candidates[i]], target - candidates[i], len, i + 1);
  }
};

const p1 = [10,1,2,7,6,1,5];
const p2 = 8;
console.log(combinationSum2(p1, p2));
