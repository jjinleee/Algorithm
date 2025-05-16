import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited=new boolean[n]; //방문여부

        //모든컴퓨터 순회
        for(int i=0;i<n;i++){
            //방문하지 않은 컴퓨터
            if(!visited[i]){
                dfs(computers, visited, i); //연결된 네트워크들 방문
                answer++; //한개의 네트워크
            }
        }
        return answer;
    }
    static void dfs(int[][] computers, boolean[] visited, int node){
        visited[node]=true; //방문
        
        for(int i=0;i<computers.length;i++){
            //연결되어있고 & 미방문
            if(computers[node][i]==1 && !visited[i]) {
                //다시 연결된것 찾음
                dfs(computers, visited, i);
            }
        }
    }
}