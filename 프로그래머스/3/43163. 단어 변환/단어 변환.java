import java.util.*;

class Solution {
    static class Word{
        String word;
        int cnt;
        
        Word(String word, int cnt){
            this.word=word;
            this.cnt=cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Word> q=new LinkedList<>();
        boolean[] visited= new boolean[words.length];
        
        q.offer(new Word(begin,0));
        while(!q.isEmpty()){
            Word c=q.poll();
            
            if(c.word.equals(target)) return c.cnt;
            
            for(int i=0;i<words.length;i++){
                if(isDiff(c.word,words[i]) && !visited[i]){
                    q.offer(new Word(words[i],c.cnt+1));
                    visited[i]=true;
                }
            }
        }
        return 0;
    }
                            
    static boolean isDiff(String a, String b){
        int cnt=0;
        
        for(int i=0;i<b.length();i++){
            if(a.charAt(i)!=b.charAt(i)) cnt++;
        }
        
        return cnt==1 ? true : false;
    }
                  
}