import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>(Collections.reverseOrder());
        
        for(String o : operations){
            String[] op=o.split(" ");
            
            if(op[0].equals("I")){
                pq.offer(Integer.parseInt(op[1]));
                pq2.offer(Integer.parseInt(op[1]));
            }
            else if(!pq.isEmpty() ){
                if(op[1].equals("-1")){
                    pq2.remove(pq.poll());
                } else pq.remove(pq2.poll());
            }            
        }
        
        return pq.isEmpty() ? new int[]{0,0} : new int[]{pq2.peek(),pq.peek()};
    }
}