import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> codi=new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            codi.put(clothes[i][1],codi.getOrDefault(clothes[i][1],0)+1);
        }
        
        int mul=1;  
       
        for(String c:codi.keySet()){
            answer*=(codi.get(c)+1);
        }
        answer-=1;

        return answer;
    }
}