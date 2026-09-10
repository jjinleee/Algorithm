import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a,b)->a[0].compareTo(b[0]));
        PriorityQueue<Integer> q= new PriorityQueue<>();
        
        for(String[] b : book_time){
            int start=toMin(b[0]);
            int end=toMin(b[1])+10;
            
            if(!q.isEmpty() && q.peek()<=start){//사용가능한 룸 있으면
                q.poll();
                q.offer(end);
            } else{
                q.offer(end);
                answer++;
            }
            
        }
        return answer;
    }
    int toMin(String t){
        String[] tmp=t.split(":");
        
        return Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
    }
}