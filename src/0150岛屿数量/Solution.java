// 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
// 此外，你可以假设该网格的四条边均被水包围。

// 示例 1：
// 输入：grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// 输出：1

// 示例 2：
// 输入：grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// 输出：3

// 提示：
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'

class Solution {
  /**
   * 并查集
   * 
   * 为每个节点找到一个父节点，该父节点代表一个并集，有多少并集，则说明连接成的节点块有多少
   * 
   * @param grid
   * @return
   */
  class UnionFind {
    // 记录有几个并集
    int count;
    // 记录并集中每个节点的排名优先级
    int[] rank;
    // 记录每个节点在并集中的父节点
    int[] parent;

    // 初始化并查集类
    public UnionFind(char[][] grid) {
      count = 0;
      int m = grid.length;
      int n = grid[0].length;
      rank = new int[m * n];
      parent = new int[m * n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          // 初始化节点的坐标key，横坐标 * 纵坐标总数 + 纵坐标
          int key = i * n + j;
          // 当前节点的值为 1时，初始化当前节点的父级为自己，并集计数器加一
          if (grid[i][j] == '1') {
            parent[key] = key;
            count++;
          }
          // 初始化各个节点的排名为 0
          rank[key] = 0;
        }
      }
    }

    // 路径压缩，即找到当前节点的最大父节点
    private int find(int key) {
      // 如果当前节点的父节点不是自己，则一直递归找父级，直到最后一个父节点
      if (parent[key] != key) {
        parent[key] = find(parent[key]);
      }
      // 是自己，直接返回
      return parent[key];
    }

    // 节点连接，通过比较两个节点的父节点优先级，将数量小的父级接到数量多的下面
    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX != rootY) {
        if (rank[rootX] < rank[rootY]) {
          parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
          parent[rootY] = rootX;
        } else {
          parent[rootX] = rootY;
          rank[rootX]++;
        }
        // 合并后，并集计数器减一
        count--;
      }
    }

    // 返回并集个数
    public int getCount() {
      return count;
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int m = grid.length;
    int n = grid[0].length;
    UnionFind uf = new UnionFind(grid);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // 符合题目条件的节点进入并集连接
        if (grid[i][j] == '1') {
          // 重置节点的值，减少连接时的重复项
          grid[i][j] = '0';
          int currKey = i * n + j;
          // 分别跟上下左右四个邻居节点进行连接，最后得出最终并集个数
          if (i + 1 < m && grid[i + 1][j] == '1') {
            uf.union(currKey, (i + 1) * n + j);
          }
          if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            uf.union(currKey, (i - 1) * n + j);
          }
          if (j + 1 < n && grid[i][j + 1] == '1') {
            uf.union(currKey, i * n + j + 1);
          }
          if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            uf.union(currKey, i * n + j - 1);
          }
        }
      }
    }

    return uf.getCount();
  }

  /**
   * dfs
   * 
   * @param grid
   * @return
   */
  public void dfs(char[][] grid, int x, int y) {
    int m = grid.length;
    int n = grid[0].length;

    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') {
      return;
    }

    grid[x][y] = '0';
    dfs(grid, x - 1, y);
    dfs(grid, x + 1, y);
    dfs(grid, x, y - 1);
    dfs(grid, x, y + 1);
  }

  public int numIslands1(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          count++;
          dfs(grid, i, j);
        }
      }
    }
    return count;
  }
}
