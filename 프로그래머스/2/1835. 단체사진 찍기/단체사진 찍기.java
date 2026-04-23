import java.util.*;

class Solution {
     char[] friends={'A','C','F','J','M','N','R','T'};
     boolean[] visited=new boolean[8]; 
     char[] line=new char[8]; //현재줄
     int answer=0;
    public int solution(int n, String[] data) {

        dfs(0,data);
        
        return answer;
    }
    void dfs(int dept, String[] data){
        if(dept==8){
            if(isValid(data)) answer++;
            return;
        }
        
        for(int i=0;i<8;i++){
            if(visited[i]) continue;
            visited[i]=true;
            line[dept]=friends[i];
            dfs(dept+1, data);
            visited[i]=false;
        }
    }
    boolean isValid(String[] data){
        int[] pos=new int[26];
        
        for(int i=0;i<8;i++){
            pos[line[i]-'A']=i;
        }
        
        for(String condition : data){
            char a=condition.charAt(0);
            char b=condition.charAt(2);
            char op=condition.charAt(3);
            int num=condition.charAt(4)-'0';
            
            int gap=Math.abs(pos[a-'A']-pos[b-'A'])-1;
            
            if(op=='='){
                if(gap!=num) return false;
            } else if(op=='<'){
                if(gap>=num) return false;
            } else if(op=='>'){
                if(gap<=num) return false;
            }
        }
        return true;
    }
}