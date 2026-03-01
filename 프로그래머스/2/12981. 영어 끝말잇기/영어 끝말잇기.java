import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set= new HashSet<>();
        set.add(words[0]);
        char last=words[0].charAt(words[0].length()-1);
        
        for(int i=1;i<words.length;i++){
            String word=words[i];
            if(set.contains(word) || word.charAt(0)!=last){
                return new int[]{ i%n+1, i/n+1};
            }
            set.add(word);
            last=word.charAt(word.length()-1);
        }
        
        return new int[]{0,0};
    }
}