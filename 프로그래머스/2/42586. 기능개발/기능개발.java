import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n=progresses.length;
        int[] left=new int[n];
        for(int i=0;i<n;i++){
            left[i]=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }
        
        int cnt=0;
        int max=left[0];
        
        Queue<Integer> q= new ArrayDeque<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            int day=left[i];
            if(day<=max) cnt++;
            else{
                result.add(cnt);
                cnt=1;
                max=left[i];
            }
        }
        result.add(cnt);
        
        return result.stream().mapToInt(i->i).toArray();
    }
}