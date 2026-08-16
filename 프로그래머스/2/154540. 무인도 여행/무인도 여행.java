import java.util.*;

class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    List<Integer> list=new ArrayList<>();
    char[][] map;
    boolean[][] visited;
    int m,n;
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
                if(!visited[i][j] && map[i][j]!='X'){
                    list.add(dfs(i,j));
                }
            }
        }
        
        if(list.isEmpty()) return new int[]{-1};
        Collections.sort(list);
        
        return list.stream().mapToInt(i->i).toArray();
    }
    int dfs(int x, int y){
        visited[x][y]=true;
        int sum=(map[x][y]-'0');
        
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            if(nx>=0 && nx<m && ny>=0 && ny<n &&!visited[nx][ny]&& map[nx][ny]!='X'){
                sum+=dfs(nx,ny);
            }
        }
        
        return sum;
    }
}