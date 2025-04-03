class Solution {
    public int solution(int n, int w, int num) {
        int row= (num-1)/w;
        int col;
        
        if(row%2==0){
            col=(num-1)%w;
        } else{
            col=w-1-(num-1)%w;
        }
        
        int cnt=0;
        for(int i=1;i<=n;i++){
            int r=(i-1)/w;
            int c;
            if(r%2==0) c=(i-1)%w;
            else c=w-1-(i-1)%w;
            
            if(c==col && r>=row){
                cnt++;
            }
        }
        return cnt;
    }
}