import java.util.*;

class Solution {
    static class Song{
        int index; //고유번호
        int time;  //재생횟수
        
        Song(int index, int time){
            this.index=index;
            this.time=time;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> list=new ArrayList<>();
        Map<String, Integer> genrePlay=new HashMap<>(); //장르별 재생횟수
        Map<String, List<Song>> genreSong=new HashMap<>(); //장르별 노래
        
        int n=genres.length;
        for(int i=0;i<n;i++){
            String g=genres[i];
            genrePlay.put(g, genrePlay.getOrDefault(g,0)+plays[i]);
            genreSong.computeIfAbsent(g, k->new ArrayList<>()).add(new Song(i,plays[i]));
        }
        
        //재생많이 된 장르 내림차순 정렬
        List<String> genre=new ArrayList<>(genrePlay.keySet());
        genre.sort((a,b)-> genrePlay.get(b)-genrePlay.get(a));
        
        //장르내 재생많이 된 곡 내림차순 정렬
        for(String gen : genre){
            List<Song> songs=genreSong.get(gen);
            songs.sort((a,b)-> a.time==b.time ? a.index-b.index : b.time-a.time);
            list.add(songs.get(0).index);
            if(songs.size()>1) list.add(songs.get(1).index);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}