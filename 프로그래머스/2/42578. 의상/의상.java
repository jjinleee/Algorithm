import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> codi=new HashMap<>();
        
        for(String[] c : clothes){
            String type=c[1];
            String clo=c[0];
            
            codi.put(type,codi.getOrDefault(type,0)+1);
        }
        
        int answer=1;
        for(int n : codi.values()){
            answer*=(n+1);
        }
        
        return answer-1;
        
        
    }
}