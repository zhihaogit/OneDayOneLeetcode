class Solution {
  numTrees1(n) {
    const G = new Array(n + 1).fill(0);
    [G[0], G[1]] = [1, 1];
    for (let i = 2; i < n + 1; i++) {
      for (let j = 1; j < i + 1; j++) {
        G[i] += G[j - 1] * G[i - j];
      }
    }
    return G[n];
  }

  numTrees2(n) {
    let C = 1;
    for (let i = 0; i < n; i++) {
      C = C * 2 * (2 * i + 1) / (i + 2);
    }
    return C;
  }
}


n = 5
ins = new Solution()
final1 = ins.numTrees1(n)
final2 = ins.numTrees2(n)
console.log(final1, final2)