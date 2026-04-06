import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int n=words.length;
        
        if(begin.equals(target)) return 0;
        List<String> list=new ArrayList<>();
        for(String w : words) list.add(w);
        if(!list.contains(target)) return 0;
        Arrays.sort(words);
        
        boolean[] visited=new boolean[n];
        Queue<String> q=new LinkedList<>();
        q.offer(begin);
        
        
        while(!q.isEmpty()){
            String cur=q.poll();
            if(cur.equals(target)) return answer;
            
            for(int i=0;i<n;i++){
                if(!visited[i] && isDiff(cur,words[i])){
                    answer++;
                    q.offer(words[i]);
                    System.out.println(words[i]);
                    visited[i]=true;
                    break;
                }
            }
        }
        
        
        return answer;
    }
    boolean isDiff(String a, String b){
        int cnt=0;
        
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) cnt++;
        }
        
        return cnt==1 ? true : false;
    }
}