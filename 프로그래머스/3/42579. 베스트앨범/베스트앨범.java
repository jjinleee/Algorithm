import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        //장르 횟수 저장
        Map<String,Integer> genreCount =new HashMap<>();
        //장르별 노래 인덱스 저장
        Map<String, List<Integer>> genreSong=new HashMap<>();
        
        int i=0;
        for(String g: genres){
            genreCount.put(g,genreCount.getOrDefault(g,0)+plays[i]); //장르카운트
            genreSong.putIfAbsent(g,new ArrayList<>());   //장르별 노래 고유번호저장
            genreSong.get(g).add(i);
            i++;
        }
        //장르정렬
        List<String> sortedGenre=new ArrayList<>(genreCount.keySet());
        sortedGenre.sort((a,b)->genreCount.get(b)-genreCount.get(a)); //내림차순
        
        List<Integer> result=new ArrayList<>();
        //많이 재생된 장르부터
        for(String max : sortedGenre){
            //해당 장르에 속한 고유번호 리스트
            List<Integer> tmp=genreSong.get(max);
            //많이 재생된 순, 같을 시 고유번호 작은순
            tmp.sort((c,d)-> plays[c]==plays[d] ? c-d : plays[d]-plays[c]);
            
            result.add(tmp.get(0));
            if(tmp.size()>1) result.add(tmp.get(1));
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}