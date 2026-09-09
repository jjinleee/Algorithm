import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int n=queries.length;
        int[] answer=new int[n];
        int[][] map=new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j]=i*columns+j+1;
            }
        }
        
        int idx=0;
        for(int[] q : queries){
            int x1=q[0]-1;
            int y1=q[1]-1;
            int x2=q[2]-1;
            int y2=q[3]-1;

        
            //시계방향회전
            int tmp=map[x1][y1];
            int min=tmp;
            //좌
            for(int i=x1;i<x2;i++){
                map[i][y1]=map[i+1][y1];
                min=Math.min(min,map[i][y1]);
                
            }
            //하
            for(int i=y1;i<y2;i++){
                map[x2][i]=map[x2][i+1];
                min=Math.min(min,map[x2][i]);

            }
            //우
            for(int i=x2;i>x1;i--){
                map[i][y2]=map[i-1][y2];
                min=Math.min(min,map[i][y2]);
            }
            //상
            for(int i=y2;i>y1;i--){
                map[x1][i]=map[x1][i-1];
                min=Math.min(min,map[x1][i]);
            }
            map[x1][y1+1]=tmp;
            
            answer[idx++]=min;
            
        }
        return answer;
    }
}