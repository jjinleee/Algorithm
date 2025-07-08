import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> type=new HashMap<>();
        for(String[] c : clothes){
            type.put(c[1],type.getOrDefault(c[1],0)+1);
        }
        
        int result=1;
        for(Integer i : type.values()){
            result*=(i+1);
        }
        
        return result-1;
        
    }
}