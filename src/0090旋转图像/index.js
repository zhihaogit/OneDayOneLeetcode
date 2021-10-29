/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function (matrix) {
  const n = matrix.length;
  for (let row = 0; row < ~~((n + 1) / 2); row++) {
    for (let col = 0; col < ~~(n / 2); col++) {
      // const tmp = matrix[row][col];
      // matrix[row][col] = matrix[n - col - 1][row];
      // matrix[n - col - 1][row] = matrix[n - row - 1][n - col - 1];
      // matrix[n - row - 1][n - col - 1] = matrix[col][n - row - 1];
      // matrix[col][n - row - 1] = tmp;
      [
        matrix[row][col],
        matrix[n - col - 1][row],
        matrix[n - row - 1][n - col - 1],
        matrix[col][n - row - 1]
      ] = [
        matrix[n - col - 1][row],
        matrix[n - row - 1][n - col - 1],
        matrix[col][n - row - 1],
        matrix[row][col]
      ];
    }
  }
};
