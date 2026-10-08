import java.util.*;

class Solution {
    int n,m;
    public int solution(int[][] land) {
        int answer = 0;
        n=land.length;
        m=land[0].length;
        
        boolean[][] visited=new boolean[n][m];
        int[] oils=new int[m];
        
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && land[i][j]==1){
                    Queue<int[]> q= new LinkedList<>();
                    Set<Integer> cols=new HashSet<>();
                    
                    int cnt=0;
                    
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        cnt++;
                        cols.add(cur[1]);
                        for(int k=0;k<4;k++){
                            int nx=cur[0]+dx[k];
                            int ny=cur[1]+dy[k];

                            if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && land[nx][ny]==1){
                                visited[nx][ny]=true;
                                q.offer(new int[]{nx,ny});
                            }
                        }

                    }
                    for(int c : cols) oils[c]+=cnt;
                    
                    
                }
            }
        }
        
        Arrays.sort(oils);
        
        return oils[m-1];
    }
}