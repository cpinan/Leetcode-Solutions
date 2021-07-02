import java.util.HashMap;
import java.util.Map;

public class CanConstruct extends BaseHelperClass {

    public boolean canConstruct(String word, String[] wordBank) {
        return canConstruct(word, wordBank, new HashMap<>());
    }

    public boolean canConstruct(String word, String[] wordBank, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        if (word.length() == 0) {
            return true;
        }

        for (String w : wordBank) {
            if (word.startsWith(w)) {
                String substring = word.substring(w.length());
                if (canConstruct(substring, wordBank, memo)) {
                    memo.put(word, true);
                    return true;
                }
            }
        }

        memo.put(word, false);
        return false;
    }

    public static void main(String[] args) {
        CanConstruct m = new CanConstruct();
        m.print(m.canConstruct("skateboard", new String[]{"br", "rd", "ate", "t", "ska", "sk", "boar"}));
        m.print(m.canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        m.print(m.canConstruct("", new String[]{"cat", "dog", "mouse"}));
    }
}
