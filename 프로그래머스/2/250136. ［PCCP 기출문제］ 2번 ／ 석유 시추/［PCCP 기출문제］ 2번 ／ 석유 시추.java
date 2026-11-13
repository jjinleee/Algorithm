import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n=land.length;
        int m=land[0].length;
        
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        boolean[][] visited=new boolean[n][m];
        
        int[] colSum=new int[m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && land[i][j]==1){
                    Queue<int[]> q=new ArrayDeque<>();
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                    int sum=1;
                    Set<Integer> cols=new HashSet<>();
                    
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        cols.add(cur[1]);
                        
                        for(int k=0;k<4;k++){
                            int nx=cur[0]+dx[k];
                            int ny=cur[1]+dy[k];
                            
                            if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && land[nx][ny]==1){
                                q.offer(new int[]{nx,ny});
                                sum++;
                                visited[nx][ny]=true;
                            }
                        }
                    }
                    
                    for(int c : cols) colSum[c]+=sum;
                }
            }
        }
        int max=0;
        for(int s : colSum) max=Math.max(s,max);
        
        return max;
    }
}