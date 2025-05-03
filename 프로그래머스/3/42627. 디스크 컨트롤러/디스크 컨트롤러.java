import java.util.*;


class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (a,b)->a[0]-b[0]); //요청시각 기준 정렬
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);//소요시간 짧은순
        
        int time=0;
        int idx=0;
        int total=0;
        int cnt=0;
        
        while(cnt<jobs.length){
            while(idx<jobs.length && jobs[idx][0]<=time){
                pq.offer(jobs[idx++]);
            }
            
            if(!pq.isEmpty()){
                int[] cur=pq.poll();
                time+=cur[1]; //현재시간+작업소요시간
                total+=(time-cur[0]); //작업종료시간-요청시각
                cnt++;
            } else time=jobs[idx][0]; //처리할 작업 없으면 다음 작업시각으로 이동
        }
        
        return total/jobs.length;
    }
}