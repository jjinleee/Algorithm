import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map=new char[m][n];
        
        int idx=0;
        for(String b : board) map[idx++]=b.toCharArray();
        
        while(true){
            boolean[][] check=new boolean[m][n];
            boolean any=false;
            
            //2x2 배열찾음
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    char c=map[i][j];
                    if(c=='0') continue;
                    
                    if(c==map[i][j+1] &&
                      c==map[i+1][j] &&
                      c==map[i+1][j+1]){
                        check[i][j]=true;
                        check[i+1][j]=true;
                        check[i][j+1]=true;
                        check[i+1][j+1]=true;
                        any=true;
                    }
                  
                }
            }
            
            if(!any) break; //더이상 지울 블록이 없음
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(check[i][j]){
                        map[i][j]='0'; //빈칸표시
                        answer++;
                    }
                }
            }
            for(int col=0;col<n;col++){
                int writeRow=m-1;
                
                for(int row=m-1;row>=0;row--){
                    if(map[row][col]!='0'){
                        char val=map[row][col];
                        map[row][col]='0';
                        map[writeRow][col]=val;
                        writeRow--;
                    }
                }
            }
            
        }
        return answer;
    }
}