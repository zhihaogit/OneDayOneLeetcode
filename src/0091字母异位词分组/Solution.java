import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。

// 示例 1:
// 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
// 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

// 示例 2:
// 输入: strs = [""]
// 输出: [[""]]

// 示例 3:
// 输入: strs = ["a"]
// 输出: [["a"]]

// 提示：
// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] 仅包含小写字母

public class Solution {

  /**
   * 排序法
   * 
   * @param strs
   * @return
   */
  public List<List<String>> groupAnagrams1(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      // 将字符串转为 char数组，进行排序
      char[] arr = str.toCharArray();
      Arrays.sort(arr);
      String srotedKey = new String(arr);
      // 以排序后的字符串作为 key，取出对应的数组，重新装填
      List<String> l = map.getOrDefault(srotedKey, new ArrayList<String>());
      l.add(str);
      map.put(srotedKey, l);
    }
    return new ArrayList<>(map.values());
  }

  /**
   * 计数法
   * 
   * @param strs
   * @return
   */
  public List<List<String>> groupAnagrams2(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      int[] count = new int[26];
      for (int i = 0; i < str.length(); i++) {
        // 找到字符串中对应字符的编码，填进数组中，相同字母对应数组的索引也相同
        count[str.charAt(i) - 'a']++;
      }
      StringBuffer kBuffer = new StringBuffer();
      for (int i = 0; i < 26; i++) {
        // 字符存在时，拼成有标志位的字符串
        if (count[i] != 0) {
          kBuffer.append('a' + i);
          kBuffer.append(count[i]);
        }
      }
      String key = kBuffer.toString();
      // 以有标志位的字符串作为 key，取出对应的数组，重新装填
      List<String> l = map.getOrDefault(key, new ArrayList<>());
      l.add(str);
      map.put(key, l);
    }
    return new ArrayList<>(map.values());
  }
}
