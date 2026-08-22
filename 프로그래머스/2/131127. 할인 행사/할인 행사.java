import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n=discount.length;
        Map<String,Integer> wants=new HashMap<>();
        for(int i=0;i<want.length;i++) wants.put(want[i],number[i]);
        
        
        Map<String,Integer> got=new HashMap<>();
        for(int start=0;start<=n-10;start++){
            got=new HashMap<>();
            for(int i=start;i<start+10;i++){
                got.put(discount[i],got.getOrDefault(discount[i],0)+1);
            }
            
            boolean isPossible=true;
            for(String w : wants.keySet()){
                if(wants.get(w)!=got.get(w)){
                    isPossible=false;
                    break;
                } 
            }
            
            if(isPossible) answer++;
        }
        
        return answer;
    }
}