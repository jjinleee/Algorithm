import java.util.*;
class Solution {
    static boolean[][] visited;
    static int n,m;
    public int solution(int[][] land) {
        int answer = 0;
        n=land.length;
        m=land[0].length;
        
        visited=new boolean[n][m];
        int[] oilByColumn=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && land[i][j]==1){
                    List<int[]> area=new ArrayList<>(); //덩어리에 속한 좌표 저장
                    int oil=dfs(i,j,land,area); //덩어리계산
                    
                    Set<Integer> cols=new HashSet<>();
                    for(int[] pos:area){
                        cols.add(pos[1]); //열인덱스 추출
                    }
                    for(int c:cols){
                        oilByColumn[c]+=oil; //열마다 석유량 더한
                    }
                }
            }
        }
        int max=0;
        for(int a:oilByColumn){
            max=Math.max(max,a);
        }
        return max;
    }
    //현재 좌표에서 연결된 석유 덩어리 찾음
    static int dfs(int x, int y,int[][] land, List<int[]> area){
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        
        Stack<int[]> stack=new Stack<>();
        stack.push(new int[]{x,y});
        visited[x][y]=true;
        area.add(new int[]{x,y});
        int count =1;
        
        while(!stack.isEmpty()){
            int[] cur= stack.pop();
            for(int d=0;d<4;d++){
                int nx=cur[0]+dx[d];
                int ny=cur[1]+dy[d];
                if(nx>=0 && nx<n && ny >=0 && ny<m){
                    if(!visited[nx][ny] && land[nx][ny]==1){
                        visited[nx][ny]=true;
                        stack.push(new int[]{nx,ny});
                        area.add(new int[]{nx,ny});
                        count++;
                    }
                }
            }
        }
        return count;
        
    }
}