import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map=new char[m][n];
        int idx=0;
        for(String b: board){
            map[idx++]=b.toCharArray();
        }
        
        int answer=0;
        
        while(true){
            boolean delete=false;
            boolean[][] bomb=new boolean[m][n];
            
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if(map[i][j]=='X') continue;
                    if(map[i][j]==map[i][j+1] && map[i][j]==map[i+1][j] && map[i][j]==map[i+1][j+1]){ //2x2찾음
                        delete=true;
                        
                        bomb[i][j]=true;
                        bomb[i][j+1]=true;
                        bomb[i+1][j]=true;
                        bomb[i+1][j+1]=true;                        
                    }
                }
            }
            
            //한번에 터뜨림
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(bomb[i][j]){
                        answer++;
                        map[i][j]='X';
                    }
                }
            }            
            
            //블록 재정렬
            for(int col=0;col<n;col++){
                int write=m-1;
                for(int row=m-1;row>=0;row--){
                    if(map[row][col]!='X'){
                        if(write!=row){
                            map[write][col]=map[row][col];
                            map[row][col]='X';
                        }
                        write--;
                    }
                }
            }
            
            if(!delete) break;
        }
        
        
        
        return answer;
    }
}