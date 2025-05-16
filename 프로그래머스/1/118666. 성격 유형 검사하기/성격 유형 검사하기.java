import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb= new StringBuilder();
        int n=survey.length;
        char[][] alpha={
            {'R','T'},
            {'C','F'},
            {'J','M'},
            {'A','N'}
        };
        
        //성격유형 저장(array로?->순서변경감지어떻게)
        Map<Character,Integer> personal=new HashMap<>();
        personal.put('R',0);
        personal.put('T',0);
        personal.put('C',0);
        personal.put('F',0);
        personal.put('J',0);
        personal.put('M',0);
        personal.put('A',0);
        personal.put('N',0);
        
        int k=0;
        //각 유형 카운트
        for(String s : survey){
            char p1=s.charAt(0);
            char p2=s.charAt(1);
            int choice=choices[k++];
            
            if(choice==0) break; //4면 아무일도없음
            int[] type=personalCount(choice);
            
            //각 성격 해시맵으로 가져와서 수정
            if(type[0]==0) personal.put(p1,personal.get(p1)+type[1]);
            else personal.put(p2,personal.get(p2)+type[1]);
        }
        
        //지표별 카운트 큰거 추가(코드가 너무 안좋은듯)
        for(int i=0;i<4;i++){
            char c1=alpha[i][0];
            char c2=alpha[i][1];
            if(personal.get(c1)>personal.get(c2)) sb.append(c1);
            else if(personal.get(c1)<personal.get(c2)) sb.append(c2);
            else sb.append(c1>c2 ? c2 : c1);
        }
        return sb.toString();
    }
    //지표
    static int[] personalCount(int choice){
        switch(choice){
            case 1 : return new int[]{0,3};
            case 2 : return new int[]{0,2};
            case 3 : return new int[]{0,1};
            case 5 : return new int[]{1,1};
            case 6 : return new int[]{1,2};
            case 7 : return new int[]{1,3};
            default : return new int[]{0,0};
        }
    }
}