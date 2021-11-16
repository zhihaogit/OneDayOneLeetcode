/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function (matrix) {
  const n = matrix.length;
  for (let i = 1; i < n; i++) {
    for (let j = 0; j < n; j++) {
      let min;
      if (j === 0) {
        min = Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
      } else if (j === n - 1) {
        min = Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
      } else {
        min = Math.min(matrix[i - 1][j], matrix[i - 1][j - 1], matrix[i - 1][j + 1]);
      }
      matrix[i][j] += min;
    }
  }
  let ans = matrix[n - 1][0];
  for (let i = 1; i < n; i++) {
    ans = Math.min(ans, matrix[n - 1][i]);
  }
  return ans;
};
