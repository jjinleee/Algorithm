class Solution {
    public int solution(String name) {
        int answer = 0;
        int n=name.length();
        for(int i=0;i<n;i++){
            char c=name.charAt(i);
            answer+=Math.min(c-'A','Z'-c+1);
        }
        
        int move=n-1;
        
        for(int i=0;i<n;i++){
            int next=i+1;
            
            while(next<n && name.charAt(next)=='A'){
                next++;
            }
            
            move=Math.min(move,i+i+n-next);
            move = Math.min(move, i + (n - next) * 2);     // 왼쪽 먼저 가는 형태

        }
        
        
        return answer+move;
    }
}