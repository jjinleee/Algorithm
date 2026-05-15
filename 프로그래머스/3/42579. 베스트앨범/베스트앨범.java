import java.util.*;

class Solution {
    class Song{
        int idx;
        int play;
        
        Song(int idx, int play){
            this.idx=idx;
            this.play=play;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> list=new ArrayList<>();
        
        Map<String, Integer> genrePlay=new HashMap<>(); //장르별 재생횟수
        Map<String, List<Song>> genreSong=new HashMap<>(); //장르별 재생곡
        for(int i=0;i<genres.length;i++){
            genrePlay.put(genres[i], genrePlay.getOrDefault(genres[i],0)+plays[i]);
            genreSong.computeIfAbsent(genres[i], k-> new ArrayList<>()).add(new Song(i, plays[i]));
            
        }
        
        //재생횟수 내림차순
        List<String> genre=new ArrayList<>(genrePlay.keySet());
        Collections.sort(genre, (a,b)-> genrePlay.get(b)-genrePlay.get(a));
        
        for(String g: genre){
            List<Song> songs= genreSong.get(g);
            //재생횟수 내림차순, 고유번호 오름차순
            Collections.sort(songs, (a,b)-> a.play==b.play ? a.idx-b.idx :b.play-a.play);
            
            list.add(songs.get(0).idx);
            if(songs.size()>1){
                list.add(songs.get(1).idx);
            } 
            
        }
        
        return list.stream().mapToInt(i->i).toArray();
        
    }
}