import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time=0;
        int idx=0;
        int cnt=0;
            
        //요청 시각 오름차순
        Arrays.sort(jobs, Comparator.comparing(a->a[0]));
        //소요시간
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        
        while(cnt<jobs.length){
            while(idx<jobs.length && jobs[idx][0]<=time){
                pq.add(jobs[idx++]);
            }
            
            if(!pq.isEmpty()){
                int[] job=pq.poll();
                time+=job[1];
                answer+=time-job[0];
                cnt++;
            } else time=jobs[idx][0];
        }
        return answer/jobs.length;
    }
}