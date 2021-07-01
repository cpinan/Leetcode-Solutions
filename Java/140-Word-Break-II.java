class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> answer = new ArrayList<>();
        List<String> words = new ArrayList<>();
        
        wordBreak(s, wordDict, words, answer);
        
        return answer;
    }
    
    private void wordBreak(String s, List<String> wordDict, List<String> words, List<String> answer) {
        if(s.length() == 0) {
            if(words.size() > 0) {
                StringBuilder b = new StringBuilder();
                for(String word : words) {
                    b.append(word);
                    b.append(" ");
                }
                answer.add(b.toString().trim());
            }
            return;
        }
        
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                String substring = s.substring(word.length());
                words.add(word);
                wordBreak(substring, wordDict, words, answer);
                words.remove(words.size() - 1);
            }
        }
        
    }
    
    
}