class Solution {
    public int solution(int[] players, int m, int k) {
        int[] s=new int[24];
        int cur=0;
        int answer = 0;
        
        for(int i=0;i<24;i++){
            //서버 종료
            if(i-k>=0){
                cur-=s[i-k];
            } 
            int need=players[i]/m;
            
            if(cur<need){
                int add=need-cur;
                cur+=add;
                answer+=add;
                s[i]=add;
            }
        }
        return answer;
    }
}