import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  Map<String, String> phoneMap = new HashMap<String, String>() {
    {
      put("2", "abc");
      put("3", "def");
      put("4", "ghi");
      put("5", "jkl");
      put("6", "mno");
      put("7", "pqrs");
      put("8", "tuv");
      put("9", "wxyz");
    }
  };

  List<String> output = new ArrayList<String>();

  public void recursion(String combine, String nextDigits) {
    if (nextDigits.length() == 0) {
      output.add(combine);
    } else {
      String digit = nextDigits.substring(0, 1);
      String letters = phoneMap.get(digit);
      for (int i = 0; i < letters.length(); i++) {
        String letter = phoneMap.get(digit).substring(i, i + 1);
        recursion(combine + letter, nextDigits.substring(1));
      }
    }
  }

  public List<String> letterCombinations(String digits) {
    if (digits.length() != 0) {
      recursion("", digits);
      return output;
    }
    return new ArrayList<>();
  }
}
