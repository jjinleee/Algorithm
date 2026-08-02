import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a,b)-> a[0]==b[0] ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        PriorityQueue<Integer> q= new PriorityQueue<>();
        for(String[] b : book_time){
            int start=toTime(b[0]);
            int end=toTime(b[1])+10;
            
            if(!q.isEmpty() && q.peek()<=start){
                q.poll();
                q.offer(end);
            } else {
                q.offer(end);
                answer++;
            }  
        }
        return answer;
    }
    int toTime(String t){
        String[] tmp=t.split(":");
        int h=Integer.parseInt(tmp[0]);
        int m=Integer.parseInt(tmp[1]);
        
        return 60*h+m;
    }
}