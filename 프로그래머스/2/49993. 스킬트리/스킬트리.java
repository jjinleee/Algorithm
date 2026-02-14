import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map= new HashMap<>();
        for(int i=0;i<skill.length();i++){
            map.put(skill.charAt(i),i);
        }

        
        for(String s : skill_trees){
            int need=0;
            boolean isOk=true;
            
            for(int i=0;i<s.length();i++){
                char c =s.charAt(i);
                Integer n=map.get(c);
                
                if(n==null) continue;
                if(need==n) need++;
                else{
                    isOk=false;
                    break;
                }
            }
            if(isOk) answer++;
            
        }
        return answer;
    }
}