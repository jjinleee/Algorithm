import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);//요청시각 순
        //소요시간 순, 요청시각순
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
    
        
        int idx=0; //아직큐에넣지않은 인덱스
        int time=0;
        int total=0;
        int cnt=0; //작업처리한 개수
        
        
        while(cnt<jobs.length){
            //현재 시간이하로 요쳥된 모든 작업 넣기
            while(idx<jobs.length && jobs[idx][0]<=time){
                pq.add(jobs[idx]);
                idx++;
            }
            if(!pq.isEmpty()){
                int[] job=pq.poll(); //가장짧은 작업
                time+=job[1];        //현재시간+=작업시간
                total+=(time-job[0]); //완료시간-요청시간
                cnt++;
            } else{
                //처리할 작업없을때 다음 요청 시간으로 점프
                time=jobs[idx][0];
            }
        }
    
        return total/jobs.length;
    }
}