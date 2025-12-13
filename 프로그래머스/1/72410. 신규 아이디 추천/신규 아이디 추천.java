class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1단계:소문자로변경
        String s=new_id.toLowerCase();
        //2단계: 금지문자제거
        s=s.replaceAll("[^a-z0-9-_.]","");
        //3단계 : 마침표 연속2개 1개로치환
        s = s.replaceAll("\\.{2,}", "."); 
        //4단계 : 마침표 처음과 끝 제거
        s = s.replaceAll("^\\.|\\.$", "");
        //5단계 : 빈문자열 a
        if(s.isEmpty()) s="a";
        //6단계 : 길이>=16 ->첫15자만
        if(s.length()>=16){
            s=s.substring(0,15);
            s=s.replaceAll("\\.$",""); //끝마침표제거
        }
        //7단계 : 길이<=2 ->마지막문자 반복
        while(s.length()<3){
            s+=s.charAt(s.length()-1);
        }
        
        return s;
    }
}