import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //남은작업일(올림사용)
        int[] left=new int[progresses.length];
        for(int i=0;i<speeds.length;i++){
            left[i]=(int)Math.ceil((100.0-progresses[i])/speeds[i]);
        }
        
        List<Integer> answer=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();

        for(int l : left){
            if(queue.isEmpty()) queue.offer(l);
            else{
                if(queue.peek()<l){ //먼저완성시 나감
                    answer.add(queue.size());
                    queue.clear();
                    queue.offer(l);
                } else { //뒤에거가 더 일찍끝나면 같이 나감
                    queue.offer(l); 
                }
            }
        }
        answer.add(queue.size());
        
        //마지막것도 넣어줘야함
        
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}