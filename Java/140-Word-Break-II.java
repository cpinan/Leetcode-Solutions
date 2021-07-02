/**
 * https://leetcode.com/problems/word-break-ii/
 **/
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

// Improved a bit
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> words = wordBreak(s, wordDict, new HashMap<>());
        
        List<String> answer = new ArrayList<>();
        for(List<String> current : words) {
            StringBuilder b = new StringBuilder();
            for(String w : current) {
                b.append(w);
                b.append(" ");
            }
            answer.add(b.toString().trim());
        }
        return answer;
    }
    
    public List<List<String>> wordBreak(String s, List<String> wordDict, Map<String, List<List<String>>> memo) {
        List<List<String>> solutions = new ArrayList<>();
        if(s.length() == 0) {
            solutions.add(new ArrayList<>());
            return solutions;
        }
        if(memo.containsKey(s)) {
            return memo.get(s);
        } else {
            memo.put(s, solutions);
        }
        
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                String substring = s.substring(word.length());                
                List<List<String>> tmp = wordBreak(substring, wordDict, memo);
                
                for(List<String> result : tmp) {
                    List<String> newSentences = new ArrayList<>(result);
                    newSentences.add(0, word);
                    memo.get(s).add(newSentences);
                }
                
            }
        }
        
        return memo.get(s);
    }
    
}