import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        int n=land.length;
        int m=land[0].length;
        Map<Integer, Integer> cols=new HashMap<>();
        
        boolean[][] visited=new boolean[n][m];
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(!visited[i][j]&& land[i][j]==1){
                    int cnt=1;
                    Queue<int[]> q= new ArrayDeque<>();
                    Set<Integer> col=new HashSet<>();
                    
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                    col.add(j);
                    
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        
                        for(int k=0;k<4;k++){
                            int nx=cur[0]+dx[k];
                            int ny=cur[1]+dy[k];
                            
                            if(nx>=0 && nx<n && ny>=0 && ny<m &&!visited[nx][ny]&& land[nx][ny]==1){
                                visited[nx][ny]=true;
                                q.offer(new int[]{nx,ny});
                                cnt++;
                                col.add(ny);
                            }
                        }
                    }
                     for(int c : col) cols.put(c, cols.getOrDefault(c,0)+cnt);
            
                }
            }
        }
            
        
        int max = 0;
        for(int c : cols.keySet()){
            max=Math.max(max, cols.get(c));
        }
        return max;
    }
}