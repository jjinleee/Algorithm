import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n=words.length;
        
        Queue<String> q= new LinkedList<>();
        boolean[] visited= new boolean[n];
        q.offer(begin);
        
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                String cur=q.poll();
                
                if(cur.equals(target)) return answer;
                
                for(int j=0;j<n;j++){
                    if(!visited[j] && isDiff(cur, words[j])){
                        visited[j]=true;
                        q.offer(words[j]);
                    }
                }
            }
            answer++;
        }
        
        return 0;
    }
    boolean isDiff(String a, String b){
        int cnt=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) cnt++;
        }
        
        return cnt==1 ? true : false;
    }
}