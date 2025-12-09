import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        //오프닝 시간
        int startm=Integer.parseInt(op_start.split(":")[0]);
        int starts=Integer.parseInt(op_start.split(":")[1]);
        int endm=Integer.parseInt(op_end.split(":")[0]);
        int ends=Integer.parseInt(op_end.split(":")[1]);
        
        int start=60*startm+starts;
        int end=60*endm+ends;
        
        //현재시각
        String[] tmp=pos.split(":");
        int m=Integer.parseInt(tmp[0]);
        int s=Integer.parseInt(tmp[1]);
        int cur=60*m+s;
        
        //영상끝시각
        int fm=Integer.parseInt(video_len.split(":")[0]);
        int fs=Integer.parseInt(video_len.split(":")[1]);
        
        if(cur>=start && cur<=end){
            m=endm;
            s=ends;
        }
        
        for(String c : commands){
            if(c.equals("next")){
                s+=10;
                if(s>=60){
                    m+=1;
                    s-=60;
                }
                //남은시간10초 미만이면 영상끝으로
                if(m>=fm && s>=fs){
                    m=fm;
                    s=fs;
                }
            } else if(c.equals("prev")){
                //현위치 10초미만이었을때
                if(m==0 && s<10) s=0;
                else{
                  s-=10;
                    if(s<0){
                        m-=1;
                        s+=60;
                    }  
                }    
            }
            //현재 재생위치가 오프닝이라면
            if(60*m+s>= start && 60*m+s<=end){
                m=endm;
                s=ends;
            }
            //System.out.println(m+":"+s);
        }
        answer=String.format("%02d:%02d",m,s);
        
        return answer;
    }
}