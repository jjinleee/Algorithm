import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result=new ArrayList<>();
        Queue<Integer> queue= new LinkedList<>();
        
        int n=progresses.length;
        int[] left=new int[n];
        for(int i=0;i<n;i++){
            left[i]=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
            System.out.println(left[i]);
        }
        
        int cnt=0;
        for(int d : left){
            if(queue.isEmpty()){
                queue.offer(d);
            } else{
                if(queue.peek()<d){
                    result.add(queue.size());
                    queue.clear();
                    queue.offer(d);
                } else {
                    queue.offer(d);
                }
            }
        }
        result.add(queue.size());
        
        return result.stream().mapToInt(i->i).toArray();
    }
}