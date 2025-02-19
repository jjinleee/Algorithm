import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> p=new HashMap<>();
        
        for(int i=0;i<participant.length;i++){
            p.put(participant[i],p.getOrDefault(participant[i],0)+1);
        }
        
        for(int i=0;i<completion.length;i++){
            if(p.get(completion[i])==1){
                p.remove(completion[i]);
            } else p.replace(completion[i],p.get(completion[i])-1);
        }
        

        answer=p.keySet().iterator().next();
        return answer;
        
    }
}