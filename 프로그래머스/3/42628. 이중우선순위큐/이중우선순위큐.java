import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer> max= new PriorityQueue<>(Collections.reverseOrder());
        
        for(String o : operations){
            StringTokenizer st= new StringTokenizer(o);
            char cmd=st.nextToken().charAt(0);
            int n=Integer.parseInt(st.nextToken());
            
            if(cmd=='I'){
                min.offer(n);
                max.offer(n);
            } else {
                if(n==1) {
                    min.remove(max.poll());
                } else max.remove(min.poll());
            }
        }
        
        return !min.isEmpty() ? new int[]{max.peek(), min.peek()} : new int[]{0,0};
    }
}