import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited=new boolean[words.length];
        int cnt=dfs(begin,target,words, 0 , visited);
        
        return cnt==Integer.MAX_VALUE ? 0 : cnt;
    }
    static int dfs(String current, String target, String[] words, int depth, boolean[] visited){
        if(current.equals(target)) return depth;        
        
        int best=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(!visited[i] && isDiff(current, words[i])){
                visited[i]=true;
                int res=dfs(words[i], target, words, depth+1, visited);
                if(res<best) best=res;
                visited[i]=false; 
            }            
        }
        
        return best;
    }
    static boolean isDiff(String a, String b){
        int cnt=0;
        
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!= b.charAt(i)) cnt++;
        }
        return cnt==1 ? true : false;
    }
}