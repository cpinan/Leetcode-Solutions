import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstruct extends BaseHelperClass {

    public List<List<String>> allConstruct(String s, String[] bank) {
        List<List<String>> list = allConstruct(s, bank, new HashMap<>());
        return list.isEmpty() || list.get(0).isEmpty() ? null : list;
    }

    private List<List<String>> allConstruct(String s, String[] bank, Map<String, List<List<String>>> memo) {
        List<List<String>> combinations = new ArrayList<>();
        if (s.length() == 0) {
            combinations.add(new ArrayList<>());
            return combinations;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        } else {
            memo.put(s, combinations);
        }

        for (String word : bank) {
            if (s.startsWith(word)) {
                List<List<String>> tmp = allConstruct(s.substring(word.length()), bank, memo);
                for (List<String> current : tmp) {
                    List<String> newList = new ArrayList<>(current);
                    newList.add(0, word);
                    combinations.add(newList);
                }
            }
        }
        return combinations;
    }

    public static void main(String[] args) {
        AllConstruct m = new AllConstruct();

        m.print(m.allConstruct("skateboard", new String[]{"br", "rd", "ate", "t", "ska", "sk", "boar"}));
        m.print(m.allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef"}));
        m.print(m.allConstruct("", new String[]{"cat", "dog", "mouse"}));
        m.print(m.allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
    }
}
