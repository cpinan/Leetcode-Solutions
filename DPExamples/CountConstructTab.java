public class CountConstructTab extends BaseHelperClass {

    public int countConstruct(String word, String[] wordBank) {
        int n = word.length();
        int[] table = new int[n + 1];
        table[0] = 1;

        for (int i = 0; i <= n; i++) {
            if (table[i] > 0) {
                for (String w : wordBank) {
                    String substring = word.substring(i);
                    if (substring.startsWith(w)) {
                        int next = i + w.length();
                        if (next <= n) {
                            table[next] += table[i];
                        }
                    }
                }
            }
        }

        return table[n];
    }

    public static void main(String[] args) {
        CountConstructTab m = new CountConstructTab();

        m.print(m.countConstruct("skateboard", new String[]{"br", "rd", "ate", "t", "ska", "sk", "boar"}));
        m.print(m.countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef"}));
        m.print(m.countConstruct("", new String[]{"cat", "dog", "mouse"}));
        m.print(m.countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
    }
}