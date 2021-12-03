/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
  if (grid == null || grid.length == 0) {
    return 0;
  }

  const dfs = (grid, x, y) => {
    const m = grid.length;
    const n = grid[0].length;
    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') {
      return;
    }
    grid[x][y] = '0';
    dfs(grid, x + 1, y);
    dfs(grid, x - 1, y);
    dfs(grid, x, y + 1);
    dfs(grid, x, y - 1);
  };

  const m = grid.length;
  const n = grid[0].length;
  let count = 0;
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] === '1') {
        count++;
        dfs(grid, i, j);
      }
    }
  }
  return count;
};
