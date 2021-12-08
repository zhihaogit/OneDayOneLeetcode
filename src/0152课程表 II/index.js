/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {number[]}
 */
var findOrder = function (numCourses, prerequisites) {
  const edges = new Array(numCourses).fill(0).map(_ => []);
  const visited = new Array(numCourses).fill(0);
  const result = new Array(numCourses).fill(0);
  let index = numCourses - 1;
  let valid = true;

  const dfs = (cur) => {
    visited[cur] = 1;
    for (let c of edges[cur]) {
      if (visited[c] === 0) {
        dfs(c);
        if (!valid) {
          return;
        }
      } else if (visited[c] === 1) {
        valid = false;
        return;
      }
    }
    visited[cur] = 2;
    result[index--] = cur;
  };

  for (let pre of prerequisites) {
    edges[pre[1]].push(pre[0]);
  }

  for (let i = 0; i < numCourses && valid; i++) {
    if (visited[i] === 0) {
      dfs(i);
    }
  }

  if (!valid) {
    return [];
  }
  return result;
};
