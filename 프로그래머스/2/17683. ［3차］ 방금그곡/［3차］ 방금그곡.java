import java.util.*;

class Solution {
    class Song{
        String title;
        int dur;
        Song(String title, int dur){
            this.title=title;
            this.dur=dur;
        }
    }
    public String solution(String m, String[] musicinfos) {
        String find=trans(m);
        List<Song> list=new ArrayList<>();

        for(String music : musicinfos){
            String[] tmp=music.split(",");
            int dur=toTime(tmp[1])-toTime(tmp[0]);
            String title=tmp[2];
            String melody=trans(tmp[3]);
            String total="";
            
            if(melody.length()>=dur) {
                total=melody.substring(0,dur);
            }
            else{
                int rep=dur/melody.length();
                int plus=dur%melody.length();
                total=melody.repeat(rep)+melody.substring(0,plus);
            }
            
            if(total.contains(find)) {
                list.add(new Song(title, dur));
            }
            
        }
        list.sort((a,b)-> b.dur-a.dur);
        
        
        return list.isEmpty() ? "(None)" : list.get(0).title ;
    }
    int toTime(String time){
        String[] tmp=time.split(":");
        return Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
    }
    String trans(String s){
        return s.replaceAll("C#","H")
                .replaceAll("D#","I")
                .replaceAll("F#","J")
                .replaceAll("G#","K")
                .replaceAll("A#","L");
    }
}