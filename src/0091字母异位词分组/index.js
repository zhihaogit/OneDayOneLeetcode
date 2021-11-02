/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
  // 计数法
  const map = {};
  for (let str of strs) {
    const count = new Array(26).fill(0);
    for (let c of str) {
      count[c.charCodeAt() - 'a'.charCodeAt()]++;
    }
    // 以数组直接作为 key，进行数据的存取
    map[count]
      ? map[count].push(str)
      : map[count] = [str];
  }
  return Object.values(map);
};
