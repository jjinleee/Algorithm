import java.util.*;

class Solution {
    //이동방향
    private static final int[] row={0,0,1,-1};
    private static final int[] col={1,-1,0,0};
        
    private static class Node{
        int r,c;
        public Node(int r,int c){
                this.r=r;
                this.c=c;
        }
    }  
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n=maps.length;
        int m=maps[0].length;
        //최단거리를 저장할 배열
        int[][] dist= new int[n][m];
        //bfs탐색큐
        ArrayDeque<Node> queue=new ArrayDeque<>();
        
        queue.addLast(new Node(0,0));
        dist[0][0]=1;
        
        while(!queue.isEmpty()){
            Node now=queue.pollFirst();
            
            for(int i=0;i<4;i++){
                int nr=now.r+row[i];
                int nc=now.c+col[i];
                
                if(nr<0 ||nc<0||nr>=n||nc>=m) continue;
                
                if(maps[nr][nc]==0) continue;
                
                if(dist[nr][nc]==0){
                    queue.addLast(new Node(nr,nc));
                    dist[nr][nc]=dist[now.r][now.c]+1;
                }
            }
        }
        
        return dist[n-1][m-1]==0 ? -1 : dist[n-1][m-1];
    }
}