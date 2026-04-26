import java.util.*;

class Solution {
    int[] tmp=new int[26];
    char[] line=new char[8];
    char[] friends={'A','C','F','J','M','N','R','T'};
    boolean[] visited=new boolean[8];
    int answer=0;
    public int solution(int n, String[] data) {
        dfs(0,data);
        return answer;
    }
    void dfs(int depth,String[] data){
        if(depth==8){
            if(isValid(data)) answer++;
            return;
        }
        
        for(int i=0;i<8;i++){
            if(!visited[i]){
                visited[i]=true;
                line[depth]=friends[i];
                dfs(depth+1,data);
                visited[i]=false;
            }
        }
    }
    boolean isValid(String[] data){
        for(int i=0;i<8;i++){
            tmp[line[i]-'A']=i; //각 알파벳이 몇번째인지 저장
        }
        
        for(String d : data){
            char a=d.charAt(0);
            char b=d.charAt(2);
            char cond=d.charAt(3);
            int n=d.charAt(4)-'0';
            
            int real=Math.abs(tmp[b-'A']-tmp[a-'A'])-1;
            
            if(cond=='='){
                if(real!=n) return false;
            } else if(cond=='>'){
                if(real<=n) return false;
            } else if(cond=='<'){
                if(real>=n) return false;
            }
        }
        
        return true;
    }
}