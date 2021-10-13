/**
 * KMP算法
 * 
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function (haystack, needle) {
  const m = needle.length;
  if (!m) {
    return 0;
  }
  // 生成 next数组，数组的每一位表示前缀和后缀相同字符的最大长度
  const next = new Array(m).fill(0);
  // i表示前缀字符串的索引，j表示后缀字符串的索引（同时也是前缀和后缀相同字符的最大长度）
  for (let i = 1, j = 0; i < m; i++) {
    // 如果 j大于 0，并且当前 i位置的数据不等于 j位置的数据，j回滚，向前取值，继续比较两个位置的值
    while (j > 0 && needle[i] !== needle[j]) {
      j = next[j - 1];
    }
    // 当前位置相同，j加一，继续循环
    if (needle[i] === needle[j]) {
      j++;
    }
    // next当前位置上记录最大长度值
    next[i] = j;
  }

  const n = haystack.length;
  // 借助 next数组寻找匹配的索引
  // i表示 haystack字符串当前的遍历的索引，j用来记录匹配模板字符串的前缀索引
  for (let i = 0, j = 0; i < n; i++) {
    while (j > 0 && haystack[i] !== needle[j]) {
      j = next[j - 1];
    }
    if (haystack[i] === needle[j]) {
      j++;
    }
    // 如果j的长度等于
    if (j === m) {
      return i - m + 1;
    }
  }

  return -1;
};
