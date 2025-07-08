import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> people=new HashMap<>();
        
        
        for(String p :  participant){
            people.put(p,people.getOrDefault(p,0)+1);
        }
        for(String c : completion){
            if(people.containsKey(c)){
                people.put(c,people.get(c)-1);                
            }
        }
        
        for(String f : people.keySet()){
            if(people.get(f)!=0) return f;
        }
        
        return "";
    }
}