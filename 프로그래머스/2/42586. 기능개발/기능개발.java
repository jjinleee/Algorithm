import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>(); 
        
        
        //남은일수저장
        int[] day=new int[progresses.length];
        for(int i=0;i<progresses.length;i++){
            day[i]=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }
        
        for(int d : day){
            if(queue.isEmpty()) queue.offer(d);
            else{
                //먼저 끝나면 먼저 나감
                if(queue.peek()<d){
                    list.add(queue.size());
                    queue.clear();
                    queue.offer(d);
                } else{ //기다림
                    queue.offer(d);
                }
            }
        }
        list.add(queue.size());
        
        return list.stream().mapToInt(i->i).toArray();
    }
}