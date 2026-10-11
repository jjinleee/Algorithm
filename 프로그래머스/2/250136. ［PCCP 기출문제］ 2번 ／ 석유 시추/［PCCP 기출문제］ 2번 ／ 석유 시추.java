import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n=land.length;
        int m=land[0].length;
        
        boolean[][] visited=new boolean[n][m];
        int[] oils=new int[m];
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && land[i][j]==1){
                    int cnt=0;
                    Set<Integer> col=new HashSet<>();
                    Queue<int[]> q= new ArrayDeque<>();
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                    
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        col.add(cur[1]);
                        cnt++;
                        for(int k=0;k<4;k++){
                            int nx=cur[0]+dx[k];
                            int ny=cur[1]+dy[k];
                            if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && land[nx][ny]==1){
                                visited[nx][ny]=true;
                                q.offer(new int[]{nx,ny});
                            }
                        }
                        
                    }
                    for(int c : col) oils[c]+=cnt;
                
                }
            }
        }
        
        Arrays.sort(oils);
        
        return oils[m-1];
    }
}