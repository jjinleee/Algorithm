import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>(Collections.reverseOrder());
        
        for(String o : operations){
            //최댓값 삭제
            if(!pq.isEmpty() && o.equals("D 1")){
                pq.remove(pq2.poll());
            }
            //최솟값 삭제
            else if (!pq.isEmpty() && o.equals("D -1")){
                pq2.remove(pq.poll());
            } else if(o.contains("I")){
                int num= Integer.parseInt(o.split(" ")[1]);
                pq.add(num);
                pq2.add(num);
            }
        }
        if(!pq.isEmpty()){
            answer[0]=pq2.peek();
            answer[1]=pq.peek();
        } 
        
        return answer;
    }
}