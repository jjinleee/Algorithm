import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map=new char[m][n];
        int idx=0;
        for(String b : board) map[idx++]=b.toCharArray();
        
        boolean[][] del=new boolean[m][n];
        while(true){
            del=new boolean[m][n];
            boolean keep=false;
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    
                    if(map[i][j]=='X') continue;
                    
                    if(map[i][j]==map[i][j+1]){
                        if(map[i][j]==map[i+1][j] && map[i][j]==map[i+1][j+1]){
                            del[i][j]=true;
                            del[i+1][j]=true;
                            del[i][j+1]=true;
                            del[i+1][j+1]=true;
                            keep=true;
                        }
                    }
                }
            }
            
            if(!keep) break; //더삭제할거없음
            
            //블록삭제
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(del[i][j]){
                        map[i][j]='X';
                        answer++;
                    }
                }
            }
            
            //블록아래로 내림
            for(int j=0;j<n;j++){
                List<Character> list=new ArrayList<>();
                for(int i=m-1;i>=0;i--){
                    if(map[i][j]!='X') list.add(map[i][j]);
                }
                int row=m-1;
                for(char l : list){
                    map[row][j]=l;
                    row--;
                }
                
                
                while(row>=0){
                    map[row][j]='X';
                    row--;
                }
            }
            
        }
        return answer;
    }
}