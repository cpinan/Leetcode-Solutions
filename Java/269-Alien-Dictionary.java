/**
 * https://leetcode.com/problems/alien-dictionary/
 **/
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
            }
        }
        
        int n = words.length;
        for(int i = 0; i < n - 1; i++) {
            String current = words[i];
            String next = words[i + 1];
            
            if(current.length() > next.length() && current.startsWith(next)) {
                return "";
            }
            
            int min = Math.min(current.length(), next.length());
            for(int j = 0; j < min; j++) {
                char c1 = current.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2) {
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }
                
        StringBuilder builder = new StringBuilder();
        Set<Character> visited = new HashSet<>();
        for(char c : graph.keySet()) {
            Set<Character> visiting = new HashSet<>();
            if(!visited.contains(c) && hasCycle(visited, visiting, graph, c, builder)) {
                return "";       
            }
        }
        
        return builder.reverse().toString();
    }
    
    private boolean hasCycle(
        Set<Character> visited,
        Set<Character> visiting,
        Map<Character, Set<Character>> graph,
        char current,
        StringBuilder builder
    ) {
        if(visiting.contains(current)) {
            return true;
        }
        
        if(visited.contains(current)) {
            return false;
        }
        
        visited.add(current);
        visiting.add(current);
        
        if(graph.containsKey(current)) {
            for(char next : graph.get(current)) {
                if(hasCycle(visited, visiting, graph, next, builder)) {
                    return true;
                }
            }
        }
        
        builder.append(current);
        visiting.remove(current);        
        return false;
    }
    
}