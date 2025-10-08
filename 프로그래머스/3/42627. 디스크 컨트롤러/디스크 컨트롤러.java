import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b)-> a[0]-b[0]); //요청시각 순으로 정렬
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[1]-b[1]);
        
        int time=0;
        int total=0;
        int i=0;
        
        while(i<jobs.length || !pq.isEmpty()){
            while(i<jobs.length && jobs[i][0]<=time) pq.offer(jobs[i++]);
            if(!pq.isEmpty()){
                int[] cur=pq.poll();
                time+=cur[1];
                total+=time-cur[0];
            } else time=jobs[i][0];
        }
        
        return total/jobs.length;
    }
}