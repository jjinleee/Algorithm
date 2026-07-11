import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxRun=0;
        m=convert(m);
        
        for(String music  : musicinfos){
            String[] tmp=music.split(",");
            int start=toMin(tmp[0]);
            int end=toMin(tmp[1]);
            
            int run=end-start;//재생시간
            String title=tmp[2];
            String melody=tmp[3];
            
            melody=convert(melody);
            
            int plus=run/melody.length()+1;
            
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<plus;i++) sb.append(melody);
            
            String newMelody=sb.toString().substring(0,run);
            
            if(newMelody.contains(m)){
                if(maxRun<run) {
                    maxRun=run;
                    answer=title;
                }
            }
            
             
        }
        return answer.isEmpty() ? "(None)" : answer;
    }
    int toMin(String s){
        String[] tmp=s.split(":");
        int h=Integer.parseInt(tmp[0]);
        int m=Integer.parseInt(tmp[1]);
        
        return 60*h+m;
    }
    String convert(String origin){
        return origin.replace("C#","1")
            .replace("D#","2")
            .replace("F#","3")
            .replace("G#","4")
            .replace("A#","5");
    }
}