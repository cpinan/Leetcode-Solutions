import java.util.HashMap;
import java.util.Map;

public class CountConstruct extends BaseHelperClass {

    public int countConstruct(String word, String[] wordBank) {
        return countConstruct(word, wordBank, new HashMap<>());
    }

    public int countConstruct(String word, String[] wordBank, Map<String, Integer> memo) {
        if (word.length() == 0) {
            return 1;
        }
        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        int ans = 0;
        for (String w : wordBank) {
            if (word.startsWith(w)) {
                ans += countConstruct(word.substring(w.length()), wordBank, memo);
            }
        }

        memo.put(word, ans);
        return ans;
    }

    public static void main(String[] args) {
        CountConstruct m = new CountConstruct();

        m.print(m.countConstruct("skateboard", new String[]{"br", "rd", "ate", "t", "ska", "sk", "boar"}));
        m.print(m.countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef"}));
        m.print(m.countConstruct("", new String[]{"cat", "dog", "mouse"}));
        m.print(m.countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
    }
}
