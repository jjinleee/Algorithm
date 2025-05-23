import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostPeople=new HashSet<>();
        Set<Integer> reservePeople= new HashSet<>();
        
        for(int l : lost) lostPeople.add(l);
        for(int r : reserve) reservePeople.add(r);
        
        Set<Integer> intersection=new HashSet<>(lostPeople);
        intersection.retainAll(reservePeople);
        lostPeople.removeAll(intersection);
        reservePeople.removeAll(intersection);
        
        //treeset은 자동정렬기능이 있어서 정렬순서로 여벌 체육복을 
        //가진 학생들을 순회할 수 있다. 
        for(int l : new TreeSet<>(reservePeople)){
            if(lostPeople.contains(l-1)){
                lostPeople.remove(l-1);
            } else if( lostPeople.contains(l+1)){
                lostPeople.remove(l+1);
            }
        }
        
        return n-lostPeople.size();
    }
}