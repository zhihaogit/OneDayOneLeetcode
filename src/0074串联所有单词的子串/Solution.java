import java.util.HashMap;
import java.util.List;

class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    int oneWordLen = words[0].length();
    int sLen = s.length();
    int wordsLen = words.length;
    List<Integer> res = new ArrayList<>();

    if (0 == sLen || 0 == wordsLen || sLen < oneWordLen) {
      return res;
    }
    HashMap<String, Integer> wordsCounter = new HashMap<>();
    for (String key : words) {
      wordsCounter.put(key, wordsCounter.getOrDefault(key, 0) + 1);
    }
    for (int i = 0; i < oneWordLen; i++) {
      int left = i;
      int right = i;
      int tmpCnt = 0;
      HashMap<String, Integer> tmpCounter = new HashMap<>();
      while (right + oneWordLen <= sLen) {
        String tmp = s.substring(right, right + oneWordLen);
        right += oneWordLen;
        if (!wordsCounter.containsKey(tmp)) {
          left = right;
          tmpCounter = new HashMap<>();
          tmpCnt = 0;
        } else {
          tmpCnt += 1;
          tmpCounter.put(tmp, tmpCounter.getOrDefault(tmp, 0) + 1);
          while (tmpCounter.get(tmp) > wordsCounter.get(tmp)) {
            String leftTmp = s.substring(left, left + oneWordLen);
            left += oneWordLen;
            tmpCnt -= 1;
            tmpCounter.put(leftTmp, tmpCounter.getOrDefault(leftTmp, 0) - 1);
          }
          if (tmpCnt == wordsLen) {
            res.add(left);
          }
        }
      }
    }
    return res;
  }
}