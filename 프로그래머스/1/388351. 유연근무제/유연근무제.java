class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n=timelogs.length;
        
        for(int i=0;i<n;i++){
            int day=startday;
            boolean early=true;
            int h=schedules[i]/100;
            int m=schedules[i]%100;

            //10분더하기
            m+=10;
            if(m>=60){
                h+=1;
                m-=60;
            }

            int time=h*100+m;
            
            for(int j=0;j<7;j++){
                
                day=(startday-1+j)%7+1;
                if(day==6 || day==7) continue; //토일은 건너뜀
                
                if(time<timelogs[i][j]) {
                    early=false;
                    break; 
                }
            }
            if(early) answer++;
        }
        return answer;
    }
}