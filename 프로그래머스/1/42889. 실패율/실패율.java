import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        int people=stages.length;
        int[] stagePeople=new int[N+2];
        for(int i=0;i<people;i++){
            stagePeople[stages[i]]+=1;
        }
        
        HashMap<Integer,Double> fail=new HashMap<>();
        for(int i=1;i<=N;i++){
            if(stagePeople[i]==0) fail.put(i,0.);
            else{
                fail.put(i,stagePeople[i]/(double)people);
                people-=stagePeople[i];
            }
        }
        
        
        return fail.entrySet().stream().sorted((a,b)->Double.compare(b.getValue(), a.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}