import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        //단어에 타겟없으면 바로 반환
        if(!Arrays.asList(words).contains(target)) return 0;
        
        //큐에넣고 방문배열
        Queue<Word> queue=new LinkedList<>();
        boolean[] visited=new boolean[words.length];
        queue.offer(new Word(begin,0));
        
        while(!queue.isEmpty()){
            Word current=queue.poll();
            //타겟에 도착시 반환
            if(current.word.equals(target)) return current.depth;
            
            for(int i=0;i<words.length;i++){
                //방문도안했고 한글자만 다르다면 큐에넣음
                if(!visited[i] && isDifferent(current.word,words[i])){
                    queue.offer(new Word(words[i],current.depth+1));
                    visited[i]=true;
                }                
            }

        }
        
        return 0;
    }
    
    //한글자만 다른지 확인
    static boolean isDifferent(String a, String b){
        int cnt=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) cnt++;
        }
        if(cnt>1) return false;
        else return true;
    }
    
    //word 클래스
    class Word{
        String word;
        int depth;
        
        Word(String word, int depth){
            this.word=word;
            this.depth=depth;
        }
        
    } 
}