import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            q.offer((int)Math.ceil((100-progresses[i])/(double)speeds[i]));
        }

        List<Integer> result=new ArrayList<>();
        
        while(!q.isEmpty()){
            int cnt=1;
            int firstDay=q.poll();
            
            while(!q.isEmpty() && firstDay>=q.peek()){
                q.poll();
                cnt++;     
            }
            result.add(cnt);
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}