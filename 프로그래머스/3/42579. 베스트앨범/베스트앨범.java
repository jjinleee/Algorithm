import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer= new ArrayList<>(); //결과담을배열, 장르에속한 곡이 하나일수도 있으니 길이를 모름-> 리스트 이용
        Map<Integer,Integer> songPlay=new HashMap<>(); //노래 고유번호,재생횟수
        Map<String,Integer> genrePlay=new HashMap<>(); //장르별 재생횟수
        Map<String, List<Integer>> genreSong= new HashMap<>(); //장르별 노래고유번호

        //장르별 재생횟수 카운트 , 노래번호-재생횟수 저장
        for(int i=0;i<plays.length;i++){
            genrePlay.put(genres[i],genrePlay.getOrDefault(genres[i],0)+plays[i]);
            songPlay.put(i,plays[i]);
        }
        
        //장르별 노래고유번호 담기
        for(int j=0;j<genres.length;j++){
            genreSong.putIfAbsent(genres[j],new ArrayList<>());
            genreSong.get(genres[j]).add(j);           
        }
        
        //장르별 재생횟수정렬
        List<String> genreSort=new ArrayList<>();
        for(String g : genrePlay.keySet()){
            genreSort.add(g);
        }
        genreSort.sort((a,b)-> genrePlay.get(b)-genrePlay.get(a));
        
        
        for(String g : genreSort){
            //장르내 재생된 노래
            List<Integer> songs=genreSong.get(g);
            //많이 재생된 순, 고유번호 낮은 순 정렬
            songs.sort((a,b)-> songPlay.get(a)==songPlay.get(b) ? a-b : songPlay.get(b)-songPlay.get(a));
            
            answer.add(songs.get(0));
            if(songs.size()>1) answer.add(songs.get(1)); //리스트사이즈 체크후 넣기
            
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}