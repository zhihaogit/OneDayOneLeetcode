class Solution {
  respace(dictionary, sentence) {
    const dictSet = new Set(dictionary);
    const length = sentence.length;
    const d = new Array(length + 1).fill(0);
    for(let i = 0; i <= length; i++) {
      d[i] = (d[i - 1] || 0) + 1;
      for (let j = 0; j <= i + 1; j++) {
        if (dictSet.has(sentence.slice(j, i))) {
          d[i] = Math.min(d[i], d[j])
        }
      }
    }
    return d[d.length - 1] - 1;
  }
}
dictionary = ["looked", "just", "like", "her", "brother", "brother"]
sentence = "jesslookedjustliketimherbrotherbrotherher"
ins = new Solution()
final1 = ins.respace(dictionary, sentence)
console.log(final1)