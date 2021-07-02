/**
* https://leetcode.com/problems/string-compression/
*/
class Solution {
    public int compress(char[] chars) {
        int size = 0;
        int count = 0;
        for(int i = 0; i < chars.length; i++) {
            count++;
            char c = chars[i];
            if(i == chars.length - 1 || c != chars[i+1]) {
                chars[size++] = chars[i];
                if(count > 1) {
                    String value = String.valueOf(count);
                    for(int j = 0; j < value.length(); j++) {
                        char v = value.charAt(j);
                        chars[size++] = v;
                    }
                }
                count = 0;
            }
        }
        return size;
    }
}