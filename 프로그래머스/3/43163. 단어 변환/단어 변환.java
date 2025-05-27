import java.util.*;

class Solution {
    static int answer=Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        //변환못하면 return 0
        if(!Arrays.asList(words).contains(target)) return 0;
        boolean[] visited=new boolean[words.length];
        
        
        for(int i=0;i<words.length;i++){
            if(!visited[i]){
                dfs(visited, begin,target, words,0);
            }
        }
        
        return answer;
    }
    
    static void dfs(boolean[] visited, String current,String target, String[] words, int cnt){
        if(current.equals(target)){
            answer=Math.min(answer,cnt);
            return;
        }
        
        for(int i=0;i<words.length;i++){
            if(!visited[i] && isDifferent(current, words[i])){
                visited[i]=true;
                dfs(visited, words[i],target, words, cnt+1 );
                visited[i]=false;
            }
        } 
    }
    //한글자만 다른지 체크
    static boolean isDifferent(String a, String b){
        int cnt=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) cnt++;
        }
        return cnt==1 ? true : false;
    }
}