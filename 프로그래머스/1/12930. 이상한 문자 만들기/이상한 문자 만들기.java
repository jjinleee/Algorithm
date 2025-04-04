import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb= new StringBuilder();
        String[] words=s.split(" ",-1);
        
        for(int i=0;i<words.length;i++){
            String word=words[i];
            for(int j=0;j<word.length();j++){
                char c=word.charAt(j);
                if(j%2==0){
                    sb.append(Character.toUpperCase(c));
                } else sb.append(Character.toLowerCase(c));
            }
            if(i!=words.length-1){
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}