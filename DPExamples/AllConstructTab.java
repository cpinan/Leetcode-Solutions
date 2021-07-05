import java.util.ArrayList;
import java.util.List;

public class AllConstructTab extends BaseHelperClass {

    public List<List<String>> allConstruct(String s, String[] bank) {
        int n = s.length();
        List<List<String>>[] table = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            table[i] = new ArrayList<>();
        }
        table[0].add(new ArrayList<>());

        for (int i = 0; i <= n; i++) {
            if (table[i].size() > 0) {
                String substring = s.substring(i);
                for (String w : bank) {
                    if (substring.startsWith(w)) {
                        int next = i + w.length();
                        if (next <= n) {
                            for (List<String> l : table[i]) {
                                table[next].add(new ArrayList<>(l));
                            }
                            for (int j = 0; j < table[next].size(); j++) {
                                table[next].get(j).add(w);
                            }
                        }
                    }
                }
            }
        }


        // System.out.println(Arrays.toString(table));

        return table[n];
    }

    public static void main(String[] args) {
        AllConstructTab m = new AllConstructTab();

        m.print(m.allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
        m.print(m.allConstruct("", new String[]{"cat", "dog", "mouse"}));
        m.print(m.allConstruct("skateboard", new String[]{"br", "rd", "ate", "t", "ska", "sk", "boar"}));
        m.print(m.allConstruct("birds", new String[]{"cat", "dog",}));

        /*
        m.print(m.allConstruct("", new String[]{"cat", "dog", "mouse"}));
        m.print(m.allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));

         */
    }
}
