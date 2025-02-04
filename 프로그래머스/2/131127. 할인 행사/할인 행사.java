import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> my=new HashMap<>();
        for(int i=0;i<want.length;i++){
            my.put(want[i],number[i]);
        }
        for(int i=0;i<discount.length-9;i++){
            HashMap<String,Integer> market=new HashMap<>();
            for(int j=i;j<i+10;j++){
              if(my.containsKey(discount[j])){
                  market.put(discount[j],market.getOrDefault(discount[j],0)+1);
              }  
            }
            
            if(market.equals(my)) answer++;

        }
        
        return answer;
    }
}