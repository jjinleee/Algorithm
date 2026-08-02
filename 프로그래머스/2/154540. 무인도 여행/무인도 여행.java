import java.util.*;

class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    char[][] map;
    int n,m;
    List<Integer> list=new ArrayList<>();
    public int[] solution(String[] maps) {
        n=maps.length;
        m=maps[0].length();
        
        int idx=0;
        map=new char[n][m];
        for(String m : maps){
            map[idx++]=m.toCharArray();
        }
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && map[i][j]!='X'){
                    list.add(dfs(visited, i,j));
                }
            }
        }
        list.sort(Comparator.naturalOrder());
        if(list.isEmpty()) return new int[]{-1};
        
        return list.stream().mapToInt(i->i).toArray();
    }
    int dfs(boolean[][] visited, int x, int y){        
        visited[x][y]=true;
        
        int sum=map[x][y]-'0';
        
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && map[nx][ny]!='X'){
                visited[nx][ny]=true;
                sum+=dfs(visited, nx, ny);
            }
        }
        
        return sum;
    }
}