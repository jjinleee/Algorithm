import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer=new ArrayList<>();
        
        int n=progresses.length;
        int[] days=new int[n];
        
        for(int i=0;i<n;i++){
            days[i]=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }
        
        int cnt=1;
        int max=days[0];
        
        for(int i=1;i<n;i++){
            if(days[i]<=max){
                cnt++;
            } else {
                answer.add(cnt);
                cnt=1;
                max=days[i];
            }
        }
        
        answer.add(cnt);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}