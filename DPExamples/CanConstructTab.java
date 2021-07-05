public class CanConstructTab extends BaseHelperClass {

    public boolean canConstruct(String word, String[] wordBank) {
        final int m = word.length();
        boolean[] table = new boolean[m + 1];
        table[0] = true;

        // O(m^2 * n) -> time
        // O(m) -> space
        for (int i = 0; i <= m; i++) {
            if (table[i]) {
                for (String w : wordBank) { // n
                    String current = word.substring(i); // m
                    if (current.startsWith(w)) {
                        int next = i + w.length();
                        if (next <= m) {
                            table[next] = true;
                        }
                    }
                }
            }
        }

        return table[m];
    }

    /*
     abcdef
       T
       F
       T
       T
       T
       F
       T
    0 -> "" == abcdef
    1 -> "a" == bcdef
    2 -> "ab" == cdef
    3 -> "abc" == def
    4 -> "abcd" == ef
    5 -> "abcde" == f
    6 -> "abcdef" = _
     */
    public static void main(String[] args) {
        CanConstructTab m = new CanConstructTab();
        m.print(m.canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        m.print(m.canConstruct("skateboard", new String[]{"br", "rd", "ate", "t", "ska", "sk", "boar"}));
        m.print(m.canConstruct("", new String[]{"cat", "dog", "mouse"}));
    }
}
