/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function (numCourses, prerequisites) {
  const edges = [];
  let visited = [];
  let valid = true;

  const dfs = (index) => {
    visited[index] = 1;
    for (let item of edges[index]) {
      if (visited[item] === 0) {
        dfs(item);
        if (!valid) {
          return;
        }
      } else if (visited[item] === 1) {
        valid = false;
        return;
      }
    }
    visited[index] = 2;
  };

  visited = new Array(numCourses).fill(0);
  for (let i = 0; i < numCourses; i++) {
    edges[i] = [];
  }
  for (let i = 0; i < prerequisites.length; i++) {
    const arr = prerequisites[i];
    edges[arr[1]].push(arr[0]);

  }
  for (let i = 0; i < numCourses && valid; i++) {
    if (visited[i] === 0) {
      dfs(i);
    }
  }
  return valid;
};
