import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> type=new HashMap<>();
        for(String[] c : clothes){
            type.put(c[1],type.getOrDefault(c[1],0)+1);
        }
        for(String t : type.keySet()){
            answer*=(type.get(t)+1);
        }
        return answer-1;
    }
}