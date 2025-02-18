import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {


        //스테이지별 도전자수
        int[] challengers=new int[N+2];
        for(int i=0;i<stages.length;i++){
            challengers[stages[i]]++;
        }
        
        //스테이지별 실패한 사용자 수
        HashMap<Integer, Double> fails=new HashMap<>();
        double total=stages.length;
        
        for(int i=1;i<=N;i++){
            if(challengers[i]==0) fails.put(i,0.);
            else{
                fails.put(i,challengers[i]/total);
                total-=challengers[i];
            }
        }
 
        
        return fails.entrySet().stream().sorted((o1,o2)->Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}