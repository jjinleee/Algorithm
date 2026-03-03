import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        int maxRun=0;
        String answer="";
        m=convert(m);
        
        for(String music : musicinfos){
            String[] part=music.split(",");
            String start=part[0];
            String end=part[1];
            int run=toMinuite(end)-toMinuite(start); //재생시간
            
            String title=part[2];
            String melody=part[3];
            
            //재생시간동안 멜로디
            melody=convert(melody);
            
            int plus = run / melody.length() + 1;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < plus; i++) {
                sb.append(melody);
            }
            String newMelody = sb.toString().substring(0, run);
            
            if(newMelody.contains(m)) {
                if(maxRun<run) {
                    maxRun=run;
                    answer=title;
                }
            }

        }
        return answer.isEmpty() ? "(None)" : answer;
    }
    int toMinuite(String time){
        int h=Integer.parseInt(time.split(":")[0]);
        int m=Integer.parseInt(time.split(":")[1]);
        
        return 60*h+m;
    }
    String convert(String s){
        return s.replace("C#","c")
                .replace("D#","d")
                .replace("F#","f")
                .replace("G#","g")
                .replace("A#","a")
                .replace("B#","b")
                .replace("E#","e");
    }
}