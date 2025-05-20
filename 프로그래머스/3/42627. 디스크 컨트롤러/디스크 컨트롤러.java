import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        //요청시각 빠른 순으로 정렬
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        
        //소요시간 순으로 정렬
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        int time=0;
        int total=0;
        int i=0; //현재 큐에들어가는것
        int count=0; //실행완료된것
        int n=jobs.length;
        
        while(count<n){    
            //현재 시간이하의 요청작업을 큐에 삽입
            while(i<n && jobs[i][0]<=time){
                pq.offer(jobs[i++]);
            }
            //실행완료된건 뺴고 반환시각계산, 반환시간=끝난시간-요청시각
            //실행완료된지 알려면 지금시간-실행시작시간>=소요시간 체크?
            if(!pq.isEmpty()) {
                int[] job=pq.poll();
                time+=job[1]; //작업수행시간
                total+=time-job[0]; //대기+수행시간c
                count++;
            } else {
                //대기할 작업 없을시 시간만흐름
                time=jobs[i][0];
            }
        }
        return total/n;
    }
}