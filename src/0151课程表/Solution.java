import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

// 示例 1：
// 输入：numCourses = 2, prerequisites = [[1,0]]
// 输出：true
// 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。

// 示例 2：
// 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
// 输出：false
// 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。

// 提示：
// 1 <= numCourses <= 105
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// prerequisites[i] 中的所有课程对 互不相同

class Solution {
  private List<List<Integer>> edges;
  private int[] visited;
  private boolean valid = true;

  /**
   * dfs
   * 
   * 给定一个包含 n个节点的有向图 G，我们给出它的节点编号的一种排列，如果满足：
   * 对于图 G中的任意一条有向边 (u, v)，u在排列中都出现在 v的前面。
   * 那么称该排列是图 G的「拓扑排序
   *
   * 基本思路，先把节点的对应关系存到一个二维数组中，再用一个数组标记节点的访问关系，如果搜索一个节点的过程中，它的相关节点为搜索中，则说明找到了一个环，不符合题意。正常搜索完成，则证明了该排列是正常的
   * 
   * @param numCourses
   * @param prerequisites
   * @return
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    // 标记 0-未搜索，1-搜索中，2-搜索完成
    visited = new int[numCourses];

    // 记录每个节点的后续节点
    edges = new ArrayList<List<Integer>>();
    for (int i = 0; i < numCourses; i++) {
      edges.add(i, new ArrayList<Integer>());
    }
    for (int i = 0; i < prerequisites.length; i++) {
      edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }

    // 遍历，如果没有该节点没有访问过，则进行搜索
    for (int i = 0; i < numCourses && valid; i++) {
      if (visited[i] == 0) {
        dfs(i);
      }
    }
    return valid;
  }

  private void dfs(int i) {
    // 标记当前节点为搜索中
    visited[i] = 1;
    for (int c : edges.get(i)) {
      // 如果当前节点的后续节点没搜索过，继续搜索
      if (visited[c] == 0) {
        dfs(c);
        if (!valid) {
          return;
        }
        // 如果后续节点显示在搜索中，说明是一个环，不符合题意
      } else if (visited[c] == 1) {
        valid = false;
        return;
      }
    }
    // 搜索正常完成，标记该节点为搜索完成
    visited[i] = 2;
  }

  private List<List<Integer>> edgesBfs;
  private int[] indeg;

  /**
   * bfs
   * 
   * 基本思路：如果一个节点的入度为 0，则加入到 queue中。如果存在环，则一定有节点的入度不为 0
   * 
   * @param numCourses
   * @param prerequisites
   * @return
   */
  public boolean canFinish1(int numCourses, int[][] prerequisites) {
    indeg = new int[numCourses];
    edgesBfs = new ArrayList<List<Integer>>();
    for (int i = 0; i < numCourses; i++) {
      edgesBfs.add(new ArrayList<>());
    }
    for (int i = 0; i < prerequisites.length; i++) {
      // 用二维数组存储每个节点之间的关系
      edgesBfs.get(prerequisites[i][1]).add(prerequisites[i][0]);
      // 用数组记录每个节点的入度数
      indeg[prerequisites[i][0]]++;
    }

    // 通过遍历，将入度数为 0的节点加入队列
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indeg[i] == 0) {
        queue.offer(i);
      }
    }

    // 设置访问数初始值为 0，如果是拓扑排序，则每个节点都会被遍历到，不能遍历到，说明有环
    int visited = 0;
    while (!queue.isEmpty()) {
      visited++;
      int curr = queue.poll();
      // 遍历当前节点的有关的节点，将有关节点的入度数自减一，如果入度数为 0，则加入到队列中
      for (int sibling : edgesBfs.get(curr)) {
        indeg[sibling]--;
        if (indeg[sibling] == 0) {
          queue.offer(sibling);
        }
      }
    }

    return visited == numCourses;
  }
}
