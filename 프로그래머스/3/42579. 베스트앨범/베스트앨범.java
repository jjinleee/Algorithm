import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> genreTotal=new HashMap<>(); //장르별 재생수
        Map<String, List<Song>> music=new HashMap<>(); //장르별 노래목록
        
        //노래데이터저장
        for(int i=0;i<genres.length;i++){
            String genre=genres[i];
            int play=plays[i];
            
            //장르별 총 재생수 누적
            genreTotal.put(genre, genreTotal.getOrDefault(genre,0)+play);
            //장르별 노래 리스트에 추가
            List<Song> list=music.getOrDefault(genre, new ArrayList<>());
            list.add(new Song(i,play)); //song객체(노래번호, 재생수)
            music.put(genre,list); //map에 다시 저장
        }
        //장르를 재생수 기준으로 내림차순
        List<String> genreSorted=new ArrayList<>(genreTotal.keySet());
        genreSorted.sort((a,b)->genreTotal.get(b)-genreTotal.get(a));
            
        List<Integer> answer=new ArrayList<>();
            
        //장르별 작업
        for(String genre:genreSorted){
            List<Song> list=music.get(genre);
            
            //해당 장르의 노래를 재생수 내림차순(같으면 고유번호 오름차순)
            list.sort((a,b)->{
                if(b.plays==a.plays) return a.index-b.index;
                return b.plays-a.plays;
            });
            
            answer.add(list.get(0).index); //첫번째노래
            if(list.size()>1) answer.add(list.get(1).index); //두번째노래
        }
        

        //int[]로 변환
        return answer.stream().mapToInt(i->i).toArray();
    }
}

//노래정보 
class Song{
    int index; //고유번호
    int plays; //재생수
    
    Song(int index, int plays){
        this.index=index;
        this.plays=plays;
    }
}