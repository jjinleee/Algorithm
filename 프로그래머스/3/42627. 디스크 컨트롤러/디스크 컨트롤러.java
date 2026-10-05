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
        //소요시간,번호 순 정렬
        PriorityQueue<Job> pq=new PriorityQueue<>((a,b)->{
            if(a.need==b.need){
                return a.num-b.num;
            }
         return a.need-b.need;
        }
        );
        
        Arrays.sort(jobs, (a,b)-> a[0]-b[0]);
        int time=0;
        int cnt=0;
        int i=0;
        int n=jobs.length;
        while(cnt<n){
            while(i<n && time>=jobs[i][0]){
                pq.offer(new Job(cnt,jobs[i][0],jobs[i][1]));
                i++;
            } 
            if(!pq.isEmpty()){
                Job cur=pq.poll();
                time+=cur.need;
                answer+=(time-cur.start);
                cnt++;
            } else time=jobs[i][0];
        }
        return answer/n;
    }
}