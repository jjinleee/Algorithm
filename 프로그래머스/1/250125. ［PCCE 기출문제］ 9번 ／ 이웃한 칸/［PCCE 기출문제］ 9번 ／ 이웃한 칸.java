class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        //보드길이, 색
        int n=board.length;
        String color=board[h][w];
        //변화량
        int[] dh={0,1,-1,0};
        int[] dw={1,0,0,-1};
        
        int hcheck=0;
        int wcheck=0;
        
        for(int i=0;i<=3;i++){
            hcheck=h+dh[i];
            wcheck=w+dw[i];
            
            if(hcheck>=0 && hcheck<n && wcheck>=0 && wcheck<n){
                if(color.equals(board[hcheck][wcheck])){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}