import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> player=new HashMap<>();
        
        for(String name: participant){
            player.put(name, player.getOrDefault(name,0)+1);
        }
        for(String name: completion){
            player.put(name, player.get(name)-1);
        }
        
        String answer="";
        for(String name: player.keySet()){
            if(player.get(name)!=0) answer=name;
        }
        
        return answer;
    }
}