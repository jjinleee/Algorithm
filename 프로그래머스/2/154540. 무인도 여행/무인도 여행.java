import java.util.*;

class Solution {
    List<Integer> list=new ArrayList<>();
    char[][] map;
    boolean[][] visited;
    int n;
    int m;
    public int[] solution(String[] maps) {
        m=maps.length;
        n=maps[0].length();
        map=new char[m][n];
        visited=new boolean[m][n];
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map[i][j]=maps[i].charAt(j);
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]!='X' && !visited[i][j]){
                    list.add(dfs(i,j));
                }
            }
        }
        
        if(list.isEmpty()) return new int[]{-1};
        
        list.sort(Comparator.naturalOrder());
        
        return list.stream().mapToInt(i->i).toArray();
    }
    int dfs(int x, int y){
        int cnt=map[x][y]-'0';
        visited[x][y]=true;
        
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            if(nx>=0 && nx<m && ny>=0 && ny<n && !visited[nx][ny] && map[nx][ny]!='X'){
                visited[nx][ny]=true;
                cnt+=dfs(nx,ny);
            }
        }
        
        return cnt;
    }
}