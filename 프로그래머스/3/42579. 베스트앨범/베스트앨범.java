import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> topGenre=new HashMap<>();
        //노래별 장르명, 고유번호, 재생횟수 저장
        HashMap<String,List<int[]>> song=new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            String genre=genres[i];
            song.putIfAbsent(genre, new ArrayList<>());
            song.get(genre).add(new int[]{i,plays[i]});
            topGenre.put(genre,topGenre.getOrDefault(genre,0)+plays[i]);
        }
        //장르 내림차순 정렬
        List<String> sortedGenre=new ArrayList<>(topGenre.keySet());
        sortedGenre.sort((a,b)->topGenre.get(b)-topGenre.get(a));
        
        List<Integer> result=new ArrayList<>();
        for(String genre:sortedGenre){
            List<int[]> songs=song.get(genre);
            songs.sort((a,b)->b[1]==a[1]? a[0]-b[0]:b[1]-a[1]);
            
            result.add(songs.get(0)[0]);
            if(songs.size()>1)  result.add(songs.get(1)[0]);

        }
        return result.stream().mapToInt(i->i).toArray(); 
    }
}