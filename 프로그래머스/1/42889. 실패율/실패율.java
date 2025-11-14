import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int total=stages.length;
        Map<Integer, Integer> step=new HashMap<>();
        for(int s : stages){
            step.put(s, step.getOrDefault(s,0)+1);
        }
        Map<Integer,Double> fail=new HashMap<>();
        
        for(int i=0;i<N;i++){
            
            int p=step.getOrDefault(i+1,0);
            if(total==0) fail.put(i+1,0.0);
            else fail.put(i+1,(double)p/total);
            total-=p;
        }
        
        int[] result = fail.entrySet().stream()
        .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())  // value 내림차순
        .mapToInt(Map.Entry::getKey)                                       // key만 추출
        .toArray();

        return result;
    }
}