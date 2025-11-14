import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] map=new int[n][n];
        int max=n*(n+1)/2;
        
        int r=0,c=0,dir=0;
        int[] dr={1,0,-1};
        int[] dc={0,1,-1};
        
        int num=1;
        while(num<=max){
            map[r][c]=num++;
            //방향 변경 여부 판단
            int nr=r+dr[dir];
            int nc=c+dc[dir];
            if(nr <0 || nc<0 || nr>n-1 || nc>n-1 || map[nr][nc]!=0){
                dir=(dir+1)%3; //방향변경
                nr=r+dr[dir];
                nc=c+dc[dir];
                
            } 
           r=nr;
            c=nc;
        }
        
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]!=0) list.add(map[i][j]);
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}