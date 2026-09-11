import java.util.*;

class Solution {
    class Job{
        int num;
        int start;
        int need;
        
        Job(int num, int start, int need){
            this.num=num;
            this.start=start;
            this.need=need;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        int n=jobs.length;
        Arrays.sort(jobs, (a,b)-> a[0]-b[0]);
        
        PriorityQueue<Job> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.need==b.need){
                    if(a.start==b.start) return a.num-b.num;
                    return a.start-b.start;
                }
                return a.need-b.need;
            }
        );
        
        int time=0;
        int cnt=0;
        int total=0;
        int i=0;
        while(cnt<n){
            //시간이 된것 대기큐에 넣음
            while(i<n &&jobs[i][0]<=time){
                pq.offer(new Job(i,jobs[i][0],jobs[i][1])); 
                i++;
            }
            
            //디스크 실행
            if(!pq.isEmpty()){
                Job cur=pq.poll();
                time+=cur.need;
                total+=(time-cur.start); //반환시각=종료시각-요청시각
                cnt++;
            } else time=jobs[i][0];
        }
        
        
        return total/n;
    }
}